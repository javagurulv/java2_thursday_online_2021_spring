package console_ui;

import services.RemoveDishService;

import java.util.Scanner;

public class RemoveDishUIAction implements UIAction {

    private RemoveDishService removeDishService;

    public RemoveDishUIAction(RemoveDishService removeBookService) {
        this.removeDishService = removeBookService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name to remove: ");
        String dishName = scanner.nextLine();
        removeDishService.execute(dishName);
        System.out.println("Your book was removed from list.");
    }

}
