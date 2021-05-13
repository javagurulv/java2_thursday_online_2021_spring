package lv.javaguru.java2.wasterestarant.console_ui.wishlist;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.AddDishToWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//Nataliya
@Component
public class AddDishToWishlistUIAction implements UIAction {

    @Autowired
    private AddDishToWishlistService addDishToWishlistService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client ID: ");
        Long clientID = getLong(scanner);
        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();
        System.out.println("Enter amount for chosen dish: ");
        int quantity = scanner.nextInt();

        AddDishToWishlistRequest request = new AddDishToWishlistRequest(clientID, dishName, quantity);
        AddDishToWishlistResponse response = addDishToWishlistService.execute(request);


        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New order item : " + response.getNewSelectedItem().getDishName() + " x "
                    + response.getNewSelectedItem().getQuantity());
            System.out.println("Your dish has been added to the wishlist");
        }


    }

    private Long getLong(Scanner scanner) {
        try{
            return Long.parseLong(scanner.nextLine());
        }
        catch(Exception e){
            return null;
        }
    }

}
