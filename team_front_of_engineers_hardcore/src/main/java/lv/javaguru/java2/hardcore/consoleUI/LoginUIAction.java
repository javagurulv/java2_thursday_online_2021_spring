package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.core.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.core.response.user.LoginResponse;
import lv.javaguru.java2.hardcore.core.services.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginUIAction implements UIAction {

    @Autowired
    private LoginService loginService;

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

