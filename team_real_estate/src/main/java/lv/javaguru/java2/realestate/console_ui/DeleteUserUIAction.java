package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.DeleteUserService;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class DeleteUserUIAction implements ConsoleUI {

    @DIDependency
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
