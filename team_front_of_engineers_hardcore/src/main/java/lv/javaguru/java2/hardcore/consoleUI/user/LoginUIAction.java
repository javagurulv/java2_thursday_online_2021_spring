package lv.javaguru.java2.hardcore.consoleUI.user;


import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;

import java.util.Scanner;

public class LoginUIAction implements UIAction {

    private LoginService loginService;

    public LoginUIAction(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter account name: ");
        String acc = scanner.nextLine();
        System.out.println("Please enter password: ");
        String pas = scanner.nextLine();
        LoginRequest request = new LoginRequest(acc, pas);
        LoginResponse response = loginService.execute(request);
    }
}

