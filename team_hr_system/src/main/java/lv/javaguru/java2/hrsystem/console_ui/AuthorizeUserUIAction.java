package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.services.user.AuthorizeUserService;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AuthorizeUserUIAction implements UIAction {

    @Autowired private AuthorizeUserService authorizeUserService;

    @Autowired private HRManagerMenu hrManagerMenu;

//    @Autowired private AdminMenu adminMenu;


    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        AuthorizeUserRequest request = new AuthorizeUserRequest(email, password);
        AuthorizeUserResponse response = authorizeUserService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );

        } else if (!response.getAuthorization().isEmpty() &&
                response.getAuthorization().get().getUserRole().equals(UserRole.ADMIN)){
            System.out.println("Hello " + response.getAuthorization().get().getFirstName() + "!");

//            adminMenu.run();

        } else if (!response.getAuthorization().isEmpty() &&
        response.getAuthorization().get().getUserRole().equals(UserRole.HR_MANAGE)){
            System.out.println("Hello " + response.getAuthorization().get().getFirstName() +"!");

            hrManagerMenu.run();

        }
    }

    @Override
    public String toString() {
        return "Authorization";
    }
}
