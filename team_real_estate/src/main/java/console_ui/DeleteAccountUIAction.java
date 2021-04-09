package console_ui;

import services.DeleteAccountService;

import java.util.Scanner;

public class DeleteAccountUIAction implements ConsoleUI{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        new DeleteAccountService().execute(username,password);
        System.out.println("Account deleted");

    }
}
