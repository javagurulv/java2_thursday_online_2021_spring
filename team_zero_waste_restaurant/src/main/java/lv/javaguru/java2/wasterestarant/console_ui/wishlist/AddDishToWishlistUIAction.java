package lv.javaguru.java2.wasterestarant.console_ui.wishlist;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.AddDishToWishlistService;

import java.util.Scanner;

//Nataliya

public class AddDishToWishlistUIAction implements UIAction {

    private AddDishToWishlistService addDishToWishlistService;

    public AddDishToWishlistUIAction(AddDishToWishlistService addDishToWishlistService) {
        this.addDishToWishlistService = addDishToWishlistService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();
        System.out.println("Enter dish ID: ");
        Long dishID = scanner.nextLong();
        System.out.println("Enter amount for chosen dish: ");
        int quantity = scanner.nextInt();
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(dishName, dishID, quantity);
        addDishToWishlistService.execute(request);
        System.out.println("New dish was added to wishlist.");
    }
}
