package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.CreateUserService;

import java.util.Scanner;

public class CreateUserUIAction implements ConsoleUI {

    CreateUserService createUserService;

    public CreateUserUIAction(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        CreateUserRequest request = new CreateUserRequest(username, password);
        CreateUserResponse response = createUserService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("User id : " + response.getUser().getId());
            System.out.println("User created");
        }
    }
}
