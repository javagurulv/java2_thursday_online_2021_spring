package lv.javaguru.java2.wasterestarant.console_ui;

import org.springframework.beans.factory.annotation.Autowired;

public class StartMenu {
    @Autowired
    public StartMenu() {
        System.out.println("1. Registration");
        System.out.println("2. Login");
    }
}
