package console_ui;

import real_estate_app.Database;
import real_estate_app.ConsoleUI;
import real_estate_app.User;

import java.util.Scanner;

class CreateAccountUIAction implements ConsoleUI {
    private final Database database;
    private static final Scanner scanner = new Scanner(System.in);

    public CreateAccountUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        User user = new User(username,password);
        System.out.println("Enter email");
        user.setEmail(scanner.nextLine());

        database.createAccount(user);
        System.out.println("Account created");
    }
}
