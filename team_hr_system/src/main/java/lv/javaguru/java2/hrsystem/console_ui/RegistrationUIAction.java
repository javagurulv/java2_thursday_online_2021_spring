package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.RegistrationResponse;
import lv.javaguru.java2.hrsystem.core.services.RegistrationService;

import java.util.Scanner;

public class RegistrationUIAction implements UIAction {

    private RegistrationService addAdminService;

    public RegistrationUIAction(RegistrationService addAdminService) {

        this.addAdminService = addAdminService;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following data");
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String secondName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        RegistrationRequest request = new RegistrationRequest(firstName, secondName, email, password);
        RegistrationResponse response = addAdminService.execute(request);

        System.out.println("Registration completed!" + "\n" + "Hello " + firstName + " " + secondName + "!");

    }

    @Override
    public String toString() {
        return "Registration";
    }
}
