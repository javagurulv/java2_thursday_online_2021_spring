package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.console_ui.*;
import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.wasterestarant.core.services.*;

import java.util.Scanner;

public class RestaurantApplication {

    private static Database database = new InMemoryDatabaseImpl();
    private static AddDishValidator addDishValidator = new AddDishValidator();
    private static AddProductValidator addProductValidator = new AddProductValidator();
    private static AddProductService addProductService = new AddProductService(database, addProductValidator);
    private static AddDishService addDishService = new AddDishService(database, addDishValidator);
    private static RemoveDishValidator removeDishValidator = new RemoveDishValidator();
    private static RemoveDishService removeDishService = new RemoveDishService(database, removeDishValidator);
    private static GetAllDishesService getAllDishesService = new GetAllDishesService(database);
    private static GetAllProductsService getAllProductsService = new GetAllProductsService(database);
    private static GetRestaurantMenuService getRestaurantMenuService = new GetRestaurantMenuService(database);
    private static GetDishesByTypeService getDishesByTypeService = new GetDishesByTypeService(database);
    private static AddDishToWishlistService addDishToWishlistService = new AddDishToWishlistService(database);
    private static GetWishlistService getWishlistServiceService = new GetWishlistService(database);

    private static UIAction addProductUIAction = new AddProductUIAction(addProductService);
    private static UIAction addDishUIAction = new AddDishUIAction(addDishService);
    private static UIAction removeDishUIAction = new RemoveDishUIAction(removeDishService);
    private static UIAction getAllDishesUIAction = new GetAllDishesUIAction(getAllDishesService);
    private static UIAction getAllProductsUIAction = new GetAllProductsUIAction(getAllProductsService);
    private static UIAction getRestaurantMenuUIAction = new GetRestaurantMenuUIAction(getRestaurantMenuService);
    private static UIAction getDishesByTypeUIAction = new GetDishesByTypeUIAction(getDishesByTypeService);
    private static UIAction addDishToWishlistUIAction = new AddDishToWishlistUIAction(addDishToWishlistService);
    private static UIAction getWishlistUIAction = new GetWishListUIAction(getWishlistServiceService);
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
        System.out.println("1. Add product to list");
        System.out.println("2. Add dish to list");
        System.out.println("3. Delete dish from list");
        System.out.println("4. Show all dishes in the list");
        System.out.println("5. Show all products in the list");
        System.out.println("6. Show full restaurant menu list");
        System.out.println("7. Show dishes by type");
        System.out.println("8. Add dish to wishlist");
        System.out.println("9. Show wishlist");
        System.out.println("10. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        int inputValuePlaceholder = 0;
        return validateUserInput(scanner, inputValuePlaceholder);
    }

    private static int validateUserInput(Scanner scanner, int inputValue ){
        while (inputValue <= 0)
        try {
            inputValue = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Enter a valid Integer value : ");
            scanner.next();
        }
        return inputValue;
    }

    private static void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addProductUIAction.execute();
                break;
            }
            case 2: {
                addDishUIAction.execute();
                break;
            }
            case 3: {
                removeDishUIAction.execute();
                break;
            }
            case 4: {
                getAllDishesUIAction.execute();
                break;
            }
            case 5: {
                getAllProductsUIAction.execute();
                break;
            }
            case 6: {
                getRestaurantMenuUIAction.execute();
                break;
            }
            case 7: {
                getDishesByTypeUIAction.execute();
                break;
            }
            case 8: {
                addDishToWishlistUIAction.execute();
                break;
            }
            case 9: {
                getWishlistUIAction.execute();
                break;
            }
            case 10: {
                exitUIAction.execute();
                break;
            }
        }
    }

}
