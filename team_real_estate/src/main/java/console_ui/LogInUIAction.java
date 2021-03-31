package console_ui;

import real_estate_app.Database;
import real_estate_app.ConsoleUI;
import real_estate_app.User;

import java.util.Scanner;

class LogInUIAction implements ConsoleUI {
    private final Database database;
    private static final Scanner scanner = new Scanner(System.in);

    public LogInUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();
        database.logIn(new User(username,password));
    }
}
