package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.SearchEmployeesBySkillService;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class SearchEmployeesBySkillUIAction implements UIAction {

   @DIDependency private SearchEmployeesBySkillService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter skill: ");
        String skill = scanner.nextLine();
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest(skill);
        SearchEmployeesBySkillResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(e -> System.out.println("Error: " + e.getField() + " " +
                    e.getMessage()));
        }
        else if (!response.getEmployees().isEmpty()) {
            response.getEmployees().forEach(e -> System.out.println("Skill: " + request.getSkillName() + " : " +
                    "Employee: " + e.getName() + " " + e.getLastName()));
        }
        else {
            System.out.println("No employees with this skill");
        }
    }

    @Override
    public String toString() {
        return "Search employees by skill";
    }
}