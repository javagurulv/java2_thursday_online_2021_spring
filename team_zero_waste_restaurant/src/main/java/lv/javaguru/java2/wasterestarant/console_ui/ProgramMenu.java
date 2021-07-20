package lv.javaguru.java2.wasterestarant.console_ui;


import lv.javaguru.java2.wasterestarant.console_ui.dish.AddDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.GetAllDishesUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.RemoveDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.SearchDishesUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.ingredient.AddDishIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.ingredient.SearchIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.CreateNewOrderUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.GetAllOrdersUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.SearchOrdersUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.AddProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.GetAllProductsUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.RemoveProductUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.SearchProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.user.ChangePasswordUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.user.ChangeUserRoleUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.user.LoginUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.user.RegistrationUIAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//AndrejsB and Andris
@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIActions(uiActions, RegistrationUIAction.class));
        menuNumberToUIActionMap.put(2, findUIActions(uiActions, LoginUIAction.class));
        menuNumberToUIActionMap.put(3, findUIActions(uiActions, AddDishUIAction.class));
        menuNumberToUIActionMap.put(4, findUIActions(uiActions, AddProductUIAction.class));
        menuNumberToUIActionMap.put(5, findUIActions(uiActions, RemoveProductUiAction.class));
        menuNumberToUIActionMap.put(6, findUIActions(uiActions, RemoveDishUIAction.class));
        menuNumberToUIActionMap.put(7, findUIActions(uiActions, SearchDishesUIAction.class));
        menuNumberToUIActionMap.put(8, findUIActions(uiActions, SearchProductUIAction.class));
        menuNumberToUIActionMap.put(9, findUIActions(uiActions, SearchIngredientUiAction.class));
        menuNumberToUIActionMap.put(10, findUIActions(uiActions, GetAllDishesUIAction.class));
        menuNumberToUIActionMap.put(11, findUIActions(uiActions, GetAllProductsUIAction.class));
        menuNumberToUIActionMap.put(12, findUIActions(uiActions, GetAllOrdersUIAction.class));
        menuNumberToUIActionMap.put(13, findUIActions(uiActions, GetRestaurantMenuUIAction.class));
        menuNumberToUIActionMap.put(14, findUIActions(uiActions, CreateNewOrderUIAction.class));
        menuNumberToUIActionMap.put(15, findUIActions(uiActions, ChangePasswordUIAction.class));
        menuNumberToUIActionMap.put(16, findUIActions(uiActions, ChangeUserRoleUIAction.class));
        menuNumberToUIActionMap.put(17, findUIActions(uiActions, ExitUIAction.class));
        menuNumberToUIActionMap.put(18, findUIActions(uiActions, SearchOrdersUIAction.class));
    }

    private UIAction findUIActions(List<UIAction> uiActions, Class uiActionClass){
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public int getMenuNumberFromAdmin() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Registration");
        System.out.println("2. Login");
        System.out.println("3. Add dish to the list");
        System.out.println("4. Add product to the list");
        System.out.println("5. Remove product from the list");
        System.out.println("6. Remove dish from the list");
        System.out.println("7. Search dishes");
        System.out.println("8. Search products");
        System.out.println("9. Search ingredients");
        System.out.println("10. Show all dishes in the list");
        System.out.println("11. Show all products in the list");
        System.out.println("12. Show all orders in the list");
        System.out.println("13. Show full restaurant menu list");
        System.out.println("14. Create new order");
        System.out.println("15. Change password");
        System.out.println("16. Change user role");
        System.out.println("17. Exit");
        System.out.println("18. Search Orders");
        System.out.println();
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
    
}
