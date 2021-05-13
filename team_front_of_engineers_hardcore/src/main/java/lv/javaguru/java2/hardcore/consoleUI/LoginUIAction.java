package lv.javaguru.java2.hardcore.consoleUI;


import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginUIAction {
    @Autowired
    private LoginService loginService;


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

