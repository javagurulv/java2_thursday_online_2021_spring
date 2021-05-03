package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.console_ui.ExitUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.GetRestaurantMenuUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.LoginUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.RegistrationUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.AddDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.GetAllDishesUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.RemoveDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.SearchDishesUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.ingredient.AddDishIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.ingredient.SearchIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.GetAllOrdersUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.AddProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.GetAllProductsUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.SearchProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.wishlist.AddDishToWishlistUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.wishlist.GetWishListUIAction;
import lv.javaguru.java2.wasterestarant.dependency_injection.ApplicationContext;

import java.util.Scanner;

public class RestaurantApplication {
    private static ApplicationContext applicationContext = new ApplicationContext();

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
        System.out.println("1. Registration");
        System.out.println("2. Login");
        System.out.println("3. Add dish to the list");
        System.out.println("4. Add product to the list");
        System.out.println("5. Remove dish from the list");
        System.out.println("6. Search dishes");
        System.out.println("7. Search products");
        System.out.println("8. Search ingredients");
        System.out.println("9. Show all dishes in the list");
        System.out.println("10. Show all products in the list");
        System.out.println("11. Show all orders in the list");
        System.out.println("12. Show full restaurant menu list");
        System.out.println("13. Add dish to wishlist");
        System.out.println("14. Show wishlist");
        System.out.println("15. Exit");
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
                RegistrationUIAction uiAction = applicationContext.getBean(RegistrationUIAction.class);
                uiAction.execute();
                break;
            }
            case 2: {
                LoginUIAction uiAction = applicationContext.getBean(LoginUIAction.class);
                uiAction.execute();
                break;
            }
            case 3: {
                AddDishUIAction uiAction1 = applicationContext.getBean(AddDishUIAction.class);
                uiAction1.execute();
                AddDishIngredientUiAction uiAction2 = applicationContext.getBean(AddDishIngredientUiAction.class);
                uiAction2.execute();
                break;
            }
            case 4: {
                AddProductUIAction uiAction = applicationContext.getBean(AddProductUIAction.class);
                uiAction.execute();
                break;
            }
            case 5: {
                RemoveDishUIAction uiAction = applicationContext.getBean(RemoveDishUIAction.class);
                uiAction.execute();
                break;
            }
            case 6: {
                SearchDishesUIAction uiAction = applicationContext.getBean(SearchDishesUIAction.class);
                uiAction.execute();
                break;
            }
            case 7: {
                SearchProductUIAction uiAction = applicationContext.getBean(SearchProductUIAction.class);
                uiAction.execute();
                break;
            }
            case 8: {
                SearchIngredientUiAction uiAction = applicationContext.getBean(SearchIngredientUiAction.class);
                uiAction.execute();
                break;
            }
            case 9: {
                GetAllDishesUIAction uiAction = applicationContext.getBean(GetAllDishesUIAction.class);
                uiAction.execute();
                break;
            }
            case 10: {
                GetAllProductsUIAction uiAction = applicationContext.getBean(GetAllProductsUIAction.class);
                uiAction.execute();
                break;
            }
            case 11: {
                GetAllOrdersUIAction uiAction = applicationContext.getBean(GetAllOrdersUIAction.class);
                //remove comment after implementation is done
                //uiAction.execute();
                break;
            }
            case 12: {
                GetRestaurantMenuUIAction uiAction = applicationContext.getBean(GetRestaurantMenuUIAction.class);
                break;
            }
            case 13: {
                AddDishToWishlistUIAction uiAction = applicationContext.getBean(AddDishToWishlistUIAction.class);
                uiAction.execute();
                break;
            }
            case 14: {
                GetWishListUIAction uiAction = applicationContext.getBean(GetWishListUIAction.class);
                uiAction.execute();
                break;
            }
            case 15: {
                ExitUIAction uiAction = applicationContext.getBean(ExitUIAction.class);
                uiAction.execute();
                break;
            }
        }
    }
}
