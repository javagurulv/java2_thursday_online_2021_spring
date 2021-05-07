package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.services.AddSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddSkillUIAction implements UIAction {

    @Autowired
    private AddSkillService service;

    @Override
    public void execute() {
        Long id = getEmployeeID();
        String[] skills = getSkills();
        for (String skill : skills) {
            AddSkillRequest request = new AddSkillRequest(id, skill);
            AddSkillResponse response = service.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(e -> System.out.println(e.getField() + " " + e.getMessage()));
            }
            else if (response.isEmployeeSkillAdded()){
                System.out.printf("Skill %s is added\n", skill);
            }
            else {
                System.out.printf("Skill %s is already added for this employee\n", skill);
            }
        }
    }

    private String[] getSkills() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter skills separated by comma: ");
        String skillsLine = scanner.nextLine();
        //scanner.close();
        return skillsLine.split("[?\\s,]+" ,-1);
    }

    private Long getEmployeeID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID for who to add skill: ");
        Long id = null;
        boolean valid = false;
        while (!valid) {
            try {
                id = Long.parseLong(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric value!");
                valid = false;
            }
        }
        //scanner.close();
        return id;
    }

    @Override
    public String toString() {
        return "Add skills for employee";
    }
}