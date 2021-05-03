package lv.javaguru.java2.wasterestarant.dependency_injection;

import lv.javaguru.java2.wasterestarant.console_ui.dish.AddDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.GetAllDishesUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.RemoveDishUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.dish.SearchDishesUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.ExitUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.GetRestaurantMenuUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.ingredient.AddDishIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.ingredient.SearchIngredientUiAction;
import lv.javaguru.java2.wasterestarant.console_ui.LoginUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.CreateNewOrderUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.order.GetAllOrdersUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.AddProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.GetAllProductsUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.product.SearchProductUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.RegistrationUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.wishlist.AddDishToWishlistUIAction;
import lv.javaguru.java2.wasterestarant.console_ui.wishlist.GetWishListUIAction;
import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.wasterestarant.core.services.dish.*;
import lv.javaguru.java2.wasterestarant.core.services.GetRestaurantMenuService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientValidator;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientValidator;
import lv.javaguru.java2.wasterestarant.core.services.LoginService;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import lv.javaguru.java2.wasterestarant.core.services.order.GetAllOrdersService;
import lv.javaguru.java2.wasterestarant.core.services.products.*;
import lv.javaguru.java2.wasterestarant.core.services.RegistrationService;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.AddDishToWishlistService;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.AddDishToWishlistValidator;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.GetWishlistService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() { }

    public void addBean(Class beanClass, Object beanInstance) {
        beans.put(beanClass, beanInstance);
        Class[] instanceInterfaces = beanClass.getInterfaces();
        for (int i = 0; i < instanceInterfaces.length; i++) {
            Class instanceInterface = instanceInterfaces[i];
            Object instance = getBean(instanceInterface);
            if (instance == null) {
                beans.put(instanceInterface, beanInstance);
            }
        }
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
