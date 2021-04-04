package console_ui;

import services.CreateAccountService;
import java.util.Scanner;

class CreateAccountUIAction implements ConsoleUI {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        new CreateAccountService().execute(username,password);
        System.out.println("Account created");

        scanner.close();
    }
}
