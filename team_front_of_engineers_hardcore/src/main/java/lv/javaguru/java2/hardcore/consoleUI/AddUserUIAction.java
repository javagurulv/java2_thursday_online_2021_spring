package lv.javaguru.java2.hardcore.consoleUI;


import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.AddUserResponse;
import lv.javaguru.java2.hardcore.core.services.user.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddUserUIAction implements UIAction {

    @Autowired
    private AddUserService addUserService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter account name: ");
        String acc = scanner.nextLine();
        System.out.println("Please enter password: ");
        String pas = scanner.nextLine();
        AddUserRequest request = new AddUserRequest(acc, pas);
        AddUserResponse response = addUserService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        }
        System.out.println("Account: " + response.getNewUser());
        System.out.println("Was added!");
    }
}
