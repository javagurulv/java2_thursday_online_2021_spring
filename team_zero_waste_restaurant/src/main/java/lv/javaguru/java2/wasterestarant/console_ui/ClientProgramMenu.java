package lv.javaguru.java2.wasterestarant.console_ui;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientProgramMenu {
    @Autowired
    public ClientProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Search dishes");
        System.out.println("2. Show all dishes");
        System.out.println("3. Show restaurant menu");
        System.out.println("4. Create new order");
        System.out.println("5. Change password");
        System.out.println("6. Exit");
        System.out.println();
    }
}
