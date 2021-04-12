package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.CreateUserService;
import java.util.Scanner;

class CreateUserUIAction implements ConsoleUI {

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

        CreateUserRequest request = new CreateUserRequest(username,password);
        CreateUserResponse response = createUserService.execute(request);

        System.out.println("Account created");

    }
}
