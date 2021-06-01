package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.Ordering;
import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchEmployeesService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SearchEmployeesRequestValidator validator;


    public SearchEmployeesResponse execute(SearchEmployeesRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new SearchEmployeesResponse(errors, null);
        }

        List<Employee> employees = search(request);
        employees = order(employees, request.getOrdering());
        employees = paging(employees, request.getPaging());

        return new SearchEmployeesResponse(null, employees);
    }

    public List<Employee> search(SearchEmployeesRequest request) {
        List<Employee> employees = null;
        if (request.isNameProvided() && !request.isTitleProvided()) {
            employees = employeeRepository.getEmployeesByName(request.getName());
        }
        if (request.isTitleProvided() && !request.isNameProvided()) {
            employees = employeeRepository.getEmployeesByTitle(EmployeeTitle.valueOf(request.getEmployeeTitle()));
        }
        if (request.isNameProvided() && request.isTitleProvided()) {
            employees = employeeRepository.getEmployeesByTitleAndName(EmployeeTitle.valueOf(request.getEmployeeTitle()), request.getName());
        }
        return employees;
    }

    private List<Employee> order(List<Employee> employees, Ordering ordering) {
        if (orderingEnabled && (ordering != null)) {
            Comparator<Employee> comparator = ordering.getOrderBy().equals("title")
                    ? Comparator.comparing(Employee::getTitle)
                    : Comparator.comparing(Employee::getName);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return employees.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return employees;
        }
    }

    private List<Employee> paging(List<Employee> employees, Paging paging) {

        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return employees.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return employees;
        }
    }
}