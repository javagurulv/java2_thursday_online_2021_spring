import console_ui.*;
import database.Database;
import database.InMemoryDatabaseImpl;
import services.AddDishService;
import services.GetAllDishesService;
import services.GetDishesByTypeService;
import services.RemoveDishService;

import java.util.Scanner;

public class DishListApplication {

    private static Database database = new InMemoryDatabaseImpl();

    private static AddDishService addDishService = new AddDishService(database);
    private static RemoveDishService removeDishService = new RemoveDishService(database);
    private static GetAllDishesService getAllDishesService = new GetAllDishesService(database);
    private static GetDishesByTypeService getDishesByTypeService = new GetDishesByTypeService(database);

    private static UIAction addDishUIAction = new AddDishUIAction(addDishService);
    private static UIAction removeDishUIAction = new RemoveDishUIAction(removeDishService);
    private static UIAction getAllDishesUIAction = new GetAllDishesUIAction(getAllDishesService);
    private static UIAction getDishesByTypeUIAction = new GetDishesByTypeUIAction(getDishesByTypeService);
    private static UIAction exitUIAction = new ExitUIAction();

    public static void main(String[] args) {
        while (true) {
            printProgramMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectedMenuItem(menuNumber);
        }
    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Add dish to list");
        System.out.println("2. Delete dish from list");
        System.out.println("3. Show all dishes in the list");
        System.out.println("4. Show dishes by type");
        System.out.println("5. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addDishUIAction.execute();
                break;
            }
            case 2: {
                removeDishUIAction.execute();
                break;
            }
            case 3: {
                getAllDishesUIAction.execute();
                break;
            }
            case 4: {
                getDishesByTypeUIAction.execute();
                break;
            }
            case 5: {
                exitUIAction.execute();
                break;
            }
        }
    }

}
