package lv.javaguru.java2.hrsystem.core.services.title;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.title.AddEmployeeTitleRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeTitleService {

    @Autowired
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    @Autowired
    private AddEmployeeTitleRequestValidator validator;

   // @Autowired
   // private EmployeeTitleRepository employeeTitleRepository;

    public AddEmployeeTitleResponse execute(AddEmployeeTitleRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeTitleResponse(errors);
        }
        EmployeeTitle employeeTitleToAdd = new EmployeeTitle(request.getTitle(), request.getDescription());
        List<EmployeeTitle> employeeTitles = ormEmployeeTitleRepository.getAllUniqueTitles();
        boolean titleAdded = false;
        if (!alreadyAdded(employeeTitles, employeeTitleToAdd)) {
            titleAdded = ormEmployeeTitleRepository.saveTitle(employeeTitleToAdd);
        }
        return new AddEmployeeTitleResponse(titleAdded);
    }

    private boolean alreadyAdded(List<EmployeeTitle> employeeTitles, EmployeeTitle employeeTitle) {
        return employeeTitles.stream()
                .anyMatch(eTitle -> eTitle.getName().equals(employeeTitle.getName()));
    }
}