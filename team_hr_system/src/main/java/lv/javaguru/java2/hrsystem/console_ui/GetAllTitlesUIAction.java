package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.GetAllTitlesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllTitlesResponse;
import lv.javaguru.java2.hrsystem.core.services.title.GetAllTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesUIAction implements UIAction {

    @Autowired
    private GetAllTitlesService service;

    @Override
    public void execute() {
        GetAllTitlesRequest request = new GetAllTitlesRequest();
        GetAllTitlesResponse response = service.execute(request);
        List<EmployeeTitle> employeeTitles = response.getEmployeeTitles();
        if (!employeeTitles.isEmpty()) {
            System.out.println("Employee titles:");
            employeeTitles.forEach(eT -> System.out.println("title id: " + eT.getId() + " | title: " +
                    eT.getName() + " | title description: " + eT.getDescription()));
        }
        else {
            System.out.println("No titles added yet!");
        }
    }

    @Override
    public String toString() {
        return "Show all currently added titles";
    }
}