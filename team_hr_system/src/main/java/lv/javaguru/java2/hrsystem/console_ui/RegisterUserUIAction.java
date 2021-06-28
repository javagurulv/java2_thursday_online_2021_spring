package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.RegisterUserResponse;
import lv.javaguru.java2.hrsystem.core.services.authorization.RegisterUserService;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class RegisterUserUIAction implements UIAction {

    @Autowired
    private RegisterUserService registration;

    private Map<Integer, UserRole> userRoleMap = new HashMap<>() {{
        put(1, UserRole.ADMIN);
        put(2, UserRole.HR_MANAGER);}};


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

        RegisterUserRequest request = new RegisterUserRequest(userRoleMap.get(select), firstName, secondName, email, password);
        RegisterUserResponse response = registration.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );

        } else {

            System.out.println("Registration completed!" + "\n" + "Hello " + response.getUser().getFirstName()
                    + " " + response.getUser().getLastName() + "!");

        }
    }

    @Override
    public String toString() {
        return "Registration";
    }
}
