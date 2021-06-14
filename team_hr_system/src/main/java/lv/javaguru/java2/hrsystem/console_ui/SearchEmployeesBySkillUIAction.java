package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesBySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SearchEmployeesBySkillUIAction implements UIAction {

    @Autowired
    private SearchEmployeesBySkillService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter skill: ");
        String skill = scanner.nextLine();
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest(skill);
        SearchEmployeesBySkillResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(e -> System.out.println(e.getField() + " " +
                    e.getMessage()));
        }
        else if (!response.getEmployeeSet().isEmpty()) {
            response.getEmployeeSet().forEach(e -> System.out.println("Employee id :" + e.getId() + " | name: " + e.getName()
            + " | last name: " + e.getLastName()));
        }
    }

    @Override
    public String toString() {
        return "Search employees by skill";
    }
}