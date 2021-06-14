package lv.javaguru.java2.hrsystem.core.services.validators.title;


import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleValidator {

    @Autowired
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    public boolean titleExists(EmployeeTitle employeeTitle) {
        return ormEmployeeTitleRepository.getAllUniqueTitles()
                .stream().anyMatch(t -> t.getName().equals(employeeTitle.getName()));
    }
}