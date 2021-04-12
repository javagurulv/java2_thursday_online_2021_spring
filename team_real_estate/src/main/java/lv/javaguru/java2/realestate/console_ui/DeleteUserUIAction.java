package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.DeleteUserService;

import java.util.Scanner;

public class DeleteUserUIAction implements ConsoleUI{

    DeleteUserService deleteUserService;

    public DeleteUserUIAction(DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        DeleteUserRequest request = new DeleteUserRequest(username,password);
        DeleteUserResponse response = deleteUserService.execute(request);

    }
}
