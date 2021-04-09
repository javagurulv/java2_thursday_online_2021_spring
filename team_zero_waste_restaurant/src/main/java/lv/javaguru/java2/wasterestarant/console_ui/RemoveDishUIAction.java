package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.services.RemoveDishService;

import java.util.Scanner;

public class RemoveDishUIAction implements UIAction {

    private RemoveDishService removeDishService;

    public RemoveDishUIAction(RemoveDishService removeDishService) {
        this.removeDishService = removeDishService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name to remove: ");
        String dishName = scanner.nextLine();
        removeDishService.execute(dishName);
        System.out.println("Your dish was removed from list.");
    }

}
