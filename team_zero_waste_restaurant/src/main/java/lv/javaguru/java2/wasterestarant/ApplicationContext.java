//package lv.javaguru.java2.wasterestarant;
//
//import lv.javaguru.java2.wasterestarant.console_ui.Dish.AddDishUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Dish.GetAllDishesUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Dish.RemoveDishUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Dish.SearchDishesUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.ExitUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.GetRestaurantMenuUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Ingredient.AddDishIngredientUiAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Ingredient.SearchIngredientUiAction;
//import lv.javaguru.java2.wasterestarant.console_ui.LoginUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Product.AddProductUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Product.GetAllProductsUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Product.SearchProductUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.RegistrationUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Wishlist.AddDishToWishlistUIAction;
//import lv.javaguru.java2.wasterestarant.console_ui.Wishlist.GetWishListUIAction;
//import lv.javaguru.java2.wasterestarant.core.database.Database;
//import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
//import lv.javaguru.java2.wasterestarant.core.services.Dish.*;
//import lv.javaguru.java2.wasterestarant.core.services.GetRestaurantMenuService;
//import lv.javaguru.java2.wasterestarant.core.services.Ingredient.AddDishIngredientService;
//import lv.javaguru.java2.wasterestarant.core.services.Ingredient.AddDishIngredientValidator;
//import lv.javaguru.java2.wasterestarant.core.services.Ingredient.SearchIngredientService;
//import lv.javaguru.java2.wasterestarant.core.services.Ingredient.SearchIngredientValidator;
//import lv.javaguru.java2.wasterestarant.core.services.LoginService;
//import lv.javaguru.java2.wasterestarant.core.services.Products.*;
//import lv.javaguru.java2.wasterestarant.core.services.RegistrationService;
//import lv.javaguru.java2.wasterestarant.core.services.Wishlist.AddDishToWishlistService;
//import lv.javaguru.java2.wasterestarant.core.services.Wishlist.GetWishlistService;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ApplicationContext {
//    private Map<Class, Object> beans = new HashMap<>();
//
//    public ApplicationContext() {
//        beans.put(Database.class, new InMemoryDatabaseImpl());
//
//        beans.put(AddDishValidator.class, new AddDishValidator());
//        beans.put(RemoveDishValidator.class, new RemoveDishValidator());
//        beans.put(SearchDishesRequestValidator.class, new SearchDishesRequestValidator());
//        beans.put(AddDishIngredientValidator.class, new AddDishIngredientValidator());
//        beans.put(SearchIngredientValidator.class, new SearchIngredientValidator());
//        beans.put(AddProductValidator.class, new AddProductValidator());
//        beans.put(SearchProductServiceValidator.class, new SearchProductServiceValidator());
//
//        beans.put(AddDishService.class, new AddDishService(
//                getBean(Database.class),
//                getBean(AddDishValidator.class)));
//        beans.put(GetAllDishesService.class, new GetAllDishesService(
//                getBean(Database.class)));
//        beans.put(RemoveDishService.class, new RemoveDishService(
//                getBean(Database.class),
//                getBean(RemoveDishValidator.class)));
//        beans.put(SearchDishesService.class, new SearchDishesService(
//                getBean(Database.class),
//                getBean(SearchDishesRequestValidator.class)));
//        beans.put(AddDishIngredientService.class, new AddDishIngredientService(
//                getBean(Database.class),
//                getBean(AddDishIngredientValidator.class)));
//        beans.put(SearchIngredientService.class, new SearchIngredientService(
//                getBean(Database.class),
//                getBean(SearchIngredientValidator.class)));
//        beans.put(AddProductService.class, new AddProductService(
//                getBean(Database.class),
//                getBean(AddProductValidator.class)));
//        beans.put(GetAllProductsService.class, new GetAllProductsService(
//                getBean(Database.class)));
//        beans.put(SearchProductService.class, new SearchProductService(
//                getBean(Database.class),
//                getBean(SearchProductServiceValidator.class)));
//        beans.put(AddDishToWishlistService.class, new AddDishToWishlistService(
//                getBean(Database.class)));
//        beans.put(GetWishlistService.class, new GetWishlistService(
//                getBean(Database.class)));
//        beans.put(GetRestaurantMenuService.class, new GetRestaurantMenuService(
//                getBean(Database.class)));
//        beans.put(LoginService.class, new LoginService(
//                getBean(Database.class)));
//        beans.put(RegistrationService.class, new RegistrationService(
//                getBean(Database.class)));
//
//        beans.put(AddDishUIAction.class, new AddDishUIAction(getBean(AddDishService.class)));
//        beans.put(GetAllDishesUIAction.class, new GetAllDishesUIAction(getBean(GetAllDishesService.class)));
//        beans.put(RemoveDishUIAction.class, new RemoveDishUIAction(getBean(RemoveDishService.class)));
//        beans.put(SearchDishesUIAction.class, new SearchDishesUIAction(getBean(SearchDishesService.class)));
//        beans.put(AddDishIngredientUiAction.class, new AddDishIngredientUiAction(getBean(AddDishIngredientService.class)));
//        beans.put(SearchIngredientUiAction.class, new SearchIngredientUiAction(getBean(SearchIngredientService.class)));
//        beans.put(AddProductUIAction.class, new AddProductUIAction(getBean(AddProductService.class)));
//        beans.put(GetAllProductsUIAction.class, new GetAllProductsUIAction(getBean(GetAllProductsService.class)));
//        beans.put(SearchProductUIAction.class, new SearchProductUIAction(getBean(SearchProductService.class)));
//        beans.put(AddDishToWishlistUIAction.class, new AddDishToWishlistUIAction(getBean(AddDishToWishlistService.class)));
//        beans.put(GetWishListUIAction.class, new GetWishListUIAction(getBean(GetWishlistService.class)));
//        beans.put(ExitUIAction.class, new ExitUIAction());
//        beans.put(GetRestaurantMenuUIAction. class, new GetRestaurantMenuUIAction(getBean(GetRestaurantMenuService.class)));
//        beans.put(LoginUIAction.class, new LoginUIAction(getBean(LoginService.class)));
//        beans.put(RegistrationUIAction.class, new RegistrationUIAction(getBean(RegistrationService.class)));
//    }
//
//    public <T extends Object> T getBean(Class c) {
//        return (T) beans.get(c);
//    }
//}
