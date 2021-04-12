package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.LogInService;

import java.util.Scanner;

class LogInUIAction implements ConsoleUI {
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

    }
}
