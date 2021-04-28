package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.LogInService;

import java.util.Scanner;

public class LogInUIAction implements ConsoleUI {
    LogInService logInService;

    public LogInUIAction(LogInService logInService) {
        this.logInService = logInService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        LogInRequest request = new LogInRequest(username, password);
        LogInResponse response = logInService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));

        } else if (response.isLoggedIn()) {
            System.out.println("User " + response.getUser().getUsername() + " logged in successfully");
        } else {
            System.out.println("Incorrect user data");
        }
    }
}
