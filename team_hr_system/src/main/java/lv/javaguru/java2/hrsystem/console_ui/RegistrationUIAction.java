package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.RegistrationResponse;
import lv.javaguru.java2.hrsystem.core.services.RegistrationService;
import lv.javaguru.java2.hrsystem.domain.UserRole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationUIAction implements UIAction {

    private RegistrationService registration;

    private Map<Integer, UserRole> userRoleMap = new HashMap<>() {{
        put(1, UserRole.ADMIN);
        put(2, UserRole.HR_MANAGE);}};
    private UserRole userRole = null;

    public RegistrationUIAction(RegistrationService addAdminService) {

        this.registration = addAdminService;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following data");

        System.out.println("Select your role: ");
        userRoleMap.forEach((key, value) -> System.out.println(key + " - " + value));
        int select = scanner.nextInt();

        scanner.nextLine();

        System.out.println("First name: ");
        String firstName = scanner.nextLine();

        System.out.println("Last name: ");
        String secondName = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        RegistrationRequest request = new RegistrationRequest(userRoleMap.get(select), firstName, secondName, email, password);
        RegistrationResponse response = registration.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );

        } else {

            System.out.println("Registration completed!" + "\n" + "Hello " + response.getUser().getFirstName()
                    + " " + response.getUser().getSecondName() + "!");

        }
    }

    @Override
    public String toString() {
        return "Registration";
    }
}
