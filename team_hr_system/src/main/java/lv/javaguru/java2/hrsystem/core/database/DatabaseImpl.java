package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.bean.EmployeeTitle;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

public class DatabaseImpl implements Database{

    private Long nextIdEmployee = 1L;
    private List <Employee> employeeList = new ArrayList<>();
    private List<EmployeeTitle> employeeTitles = new ArrayList<>();

    @Override
    public void saveEmployee(Employee employee) {
        employee.setId(nextIdEmployee);
        nextIdEmployee++;
        employeeList.add(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        return employeeList.stream()
                .filter(employee -> employee.getTitle() != null && employee.getTitle().equals(title))
                .collect(toList());
    }

    @Override
    public List<EmployeeTitle> getAllTitles() {
        return employeeTitles;
    }
}