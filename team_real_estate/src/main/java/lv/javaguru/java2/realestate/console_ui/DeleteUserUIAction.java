package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.services.DeleteUserService;

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

        deleteUserService.execute(username,password);
        System.out.println("Account deleted");

    }
}
