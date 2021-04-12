package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.requests.CreateAccountRequest;
import lv.javaguru.java2.realestate.response.CreateAccountResponse;
import lv.javaguru.java2.realestate.services.CreateAccountService;
import java.util.Scanner;

class CreateAccountUIAction implements ConsoleUI {

    CreateAccountService createAccountService;

    public CreateAccountUIAction(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        CreateAccountRequest request = new CreateAccountRequest(username,password);
        CreateAccountResponse response = createAccountService.execute(request);

        System.out.println("Account created");

    }
}
