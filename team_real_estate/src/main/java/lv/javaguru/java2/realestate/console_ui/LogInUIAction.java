package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.services.LogInService;
import java.util.Scanner;

class LogInUIAction implements ConsoleUI {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        new LogInService().execute(username, password);
        System.out.println("Logged in");
        scanner.close();
    }
}
