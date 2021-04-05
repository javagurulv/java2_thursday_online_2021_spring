package console_ui;

import database.Database;
import services.AddDishService;

import java.util.Scanner;

public class AddDishUIAction implements UIAction {

    private Database database;

    private AddDishService addDishService;

    public AddDishUIAction(AddDishService addDishService) {
        this.addDishService = addDishService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();

        System.out.println("Enter dish description: ");
        String dishDescription = scanner.nextLine();

        System.out.println("Enter dish type: ");
        String dishType = scanner.nextLine();

        System.out.println("Enter dish composition: ");
        String dishComposition = scanner.nextLine();

        System.out.println("Enter dish weight: ");
        double dishWeight = scanner.nextDouble();

        System.out.println("Enter dish price: ");
        double dishPrice = scanner.nextDouble();

        addDishService.execute(dishName, dishDescription, dishType, dishComposition, dishWeight, dishPrice);
        System.out.println("New dish was added to the list.");
    }

}
