package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.DeleteUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteUserResponse;
import lv.javaguru.java2.hrsystem.core.services.user.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteUserUIAction implements UIAction{

    @Autowired
    private DeleteUserService deleteUserService;

    @Override
    public void execute() {
        Long id = getId();

        DeleteUserRequest deleteUserRequest = new DeleteUserRequest(id);
        DeleteUserResponse deleteUserResponse = deleteUserService.execute(deleteUserRequest);

        if (deleteUserResponse.hasErrors()) {

            deleteUserResponse.getErrors().forEach(e -> System.out.println(e.getField() + " " + e.getMessage()));

        } else if (deleteUserResponse.isRemoved()) {
            System.out.println("User removed!");
        } else {
            System.out.println("User is not removed!");
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
        return "Delete User";
    }
}
