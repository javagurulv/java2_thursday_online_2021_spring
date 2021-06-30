package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.UpdateUserRoleRequest;
import lv.javaguru.java2.hrsystem.core.responses.UpdateUserRoleResponse;
import lv.javaguru.java2.hrsystem.core.services.user.UpdateUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateUserRoleUIAction implements UIAction{

    @Autowired UpdateUserRoleService updateUserRoleService;

    private Map<Integer, UserRole> userRoleMap = new HashMap<>() {{
        put(1, UserRole.ADMIN);
        put(2, UserRole.HR_MANAGER);}};

    @Override
    public void execute() {
        Long id = getId();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select role: ");
        userRoleMap.forEach((key, value) -> System.out.println(key + " - " + value));

        int select = scanner.nextInt();

        UpdateUserRoleRequest updateUserRoleRequest = new UpdateUserRoleRequest(id, userRoleMap.get(select));
        UpdateUserRoleResponse updateUserRoleResponse = updateUserRoleService.execute(updateUserRoleRequest);

        if(updateUserRoleResponse.getUpdate()){

            System.out.println("Update completed!");

        } else {

            System.out.println("Error!");

        }
    }

    private Long getId() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID!");

        boolean valid = false;

        Long id = null;

        while (!valid) {
            try {

                id = Long.parseLong(scanner.nextLine());
                valid = true;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter numeric value!");
                valid = false;

            }
        }
        return id;
    }

    @Override
    public String toString() {
        return "Update User role";
    }

}
