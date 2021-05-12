package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteUserUIAction implements ConsoleUI {

    @Autowired
    private DeleteUserService deleteUserService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        DeleteUserRequest request = new DeleteUserRequest(username, password);
        DeleteUserResponse response = deleteUserService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("User deleted : " + response.isUserDeleted());
        }

    }
}
