package lv.javaguru.java2.hrsystem.console_ui;

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

        if (loginAdminService.execute(email, password)) {

            System.out.println("Login completed!");

        } else {

            System.out.println("Error!");

        }
    }
}
