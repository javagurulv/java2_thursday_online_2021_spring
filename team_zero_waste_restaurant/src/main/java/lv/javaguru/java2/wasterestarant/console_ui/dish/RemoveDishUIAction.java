package lv.javaguru.java2.wasterestarant.console_ui.dish;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.RemoveDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// AndrejsB
@Component
public class RemoveDishUIAction implements UIAction {

    @Autowired
    private RemoveDishService removeDishService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name to remove: ");
        String dishNameToRemove = scanner.nextLine();
        RemoveDishRequest request = new RemoveDishRequest(dishNameToRemove);
        RemoveDishResponse response = removeDishService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " +
                    coreError.getField() + " " + coreError.getField()));
        } else {
            if (response.isDishNameDeleted()) {
                System.out.println("Your dish was succesfully removed from the list.");
            } else {
                System.out.println("Your dish was not removed from the list. " +
                        "Please enter a valid name from the list.");
            }
        }
    }
}
