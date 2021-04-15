package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.LoginRequest;
import lv.javaguru.java2.hrsystem.core.responses.LoginResponse;
import lv.javaguru.java2.hrsystem.core.services.LoginService;

import java.util.Scanner;

public class LoginUIAction implements UIAction {

    private LoginService loginAdminService;

    public LoginUIAction(LoginService loginAdminService) {

        this.loginAdminService = loginAdminService;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        LoginRequest request = new LoginRequest(email, password);
        LoginResponse response = loginAdminService.execute(request);

    }
}
