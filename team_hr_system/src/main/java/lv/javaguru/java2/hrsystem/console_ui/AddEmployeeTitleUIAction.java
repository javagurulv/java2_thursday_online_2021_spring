package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.title.AddEmployeeTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddEmployeeTitleUIAction implements UIAction {

    @Autowired
    private AddEmployeeTitleService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter title description: ");
        String description = scanner.nextLine();

        AddEmployeeTitleRequest request = new AddEmployeeTitleRequest(title, description);
        AddEmployeeTitleResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println(coreError.getField() + " " + coreError.getMessage())
            );
        } else if (response.isTitleAdded()) {
            System.out.println("Title is added!");
        } else {
            System.out.println("This title is already added!");
        }
    }

    @Override
    public String toString() {
        return "Add new employee title";
    }
}