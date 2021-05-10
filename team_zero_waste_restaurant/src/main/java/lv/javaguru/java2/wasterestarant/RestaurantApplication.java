package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.config.RestaurantApplicationConfiguration;
import lv.javaguru.java2.wasterestarant.console_ui.*;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class RestaurantApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestaurantApplicationConfiguration.class);

        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }
    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(RestaurantApplicationConfiguration.class);
    }
}
