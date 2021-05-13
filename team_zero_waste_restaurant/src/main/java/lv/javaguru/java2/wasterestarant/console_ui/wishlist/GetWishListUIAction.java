package lv.javaguru.java2.wasterestarant.console_ui.wishlist;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.GetWishlistService;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

//Nataliya
@Component
public class GetWishListUIAction implements UIAction {

    @Autowired
    private GetWishlistService getWishlistService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client ID to show his wishlist: ");
        Long clientID = scanner.nextLong();
        GetWishlistRequest request = new GetWishlistRequest(clientID);
        GetWishlistResponse response = getWishlistService.execute(request);
        System.out.println("__________Wishlist__________");
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() +
                    " " + coreError.getMessage()));
        } else {
            List<OrderItem> printList = response.getWishlist();
            for (int i = 0; i < printList.size(); i++) {
                printWishlistWithFields(printList, i);
            }
            System.out.println("________________end_______________");
        }

    }

    private void printWishlistWithFields(List<OrderItem> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getDishName() +
                ", quantity - " + printList.get(i).getQuantity() + ".");
    }

}
