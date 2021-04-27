package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizationRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizationResponse;
import lv.javaguru.java2.hrsystem.core.services.AuthorizationService;
import lv.javaguru.java2.hrsystem.domain.UserRole;

import java.util.Scanner;

public class AuthorizationUIAction implements UIAction {

    private AuthorizationService loginAdminService;

    public AuthorizationUIAction(AuthorizationService loginAdminService) {

        this.loginAdminService = loginAdminService;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        AuthorizationRequest request = new AuthorizationRequest(email, password);
        AuthorizationResponse response = loginAdminService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else if (!response.getAuthorization().isEmpty() &&
                response.getAuthorization().get().getUserRole().equals(UserRole.ADMIN)){
            System.out.println("Hello " + response.getAuthorization().get().getFirstName() + "!");

            var uiMain = new UIMain();
            uiMain.run();

        } else if (!response.getAuthorization().isEmpty() &&
        response.getAuthorization().get().getUserRole().equals(UserRole.HR_MANAGE)){
            System.out.println("Hello " + response.getAuthorization().get().getFirstName() +"!");

        }
    }

    @Override
    public String toString() {
        return "Authorization";
    }
}
