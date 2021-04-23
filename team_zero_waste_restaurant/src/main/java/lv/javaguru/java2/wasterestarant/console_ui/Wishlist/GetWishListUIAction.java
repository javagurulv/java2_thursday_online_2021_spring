package lv.javaguru.java2.wasterestarant.console_ui.Wishlist;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.Wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.Wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.services.Wishlist.GetWishlistService;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;
import java.util.Scanner;

//Nataliya - in process

public class GetWishListUIAction implements UIAction {

    private GetWishlistService getWishlistService;

    public GetWishListUIAction(GetWishlistService getWishlistService) {
        this.getWishlistService = getWishlistService;
    }

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
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", quantity - " + printList.get(i).getQuantity() + ".");
    }

}
