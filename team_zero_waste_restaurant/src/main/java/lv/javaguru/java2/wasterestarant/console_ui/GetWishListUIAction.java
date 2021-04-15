package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetWishListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.services.GetWishlistService;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;

import java.util.List;

//Nataliya - in process

public class GetWishListUIAction implements UIAction{
    private GetWishlistService getWishlistService;

    public GetWishListUIAction(GetWishlistService getWishlistService) {
        this.getWishlistService = getWishlistService;
    }

    @Override
    public void execute() {
        System.out.println("__________Wish list__________");
        GetWishListRequest request = new GetWishListRequest();
        GetWishlistResponse response = getWishlistService.execute(request);
        List<OrderItem> printList = response.getWishList();
        for (int i = 0; i < printList.size(); i++) {
            printWishListWithFields(printList, i);
        }
        System.out.println("_____________end_____________");
    }

    private void printWishListWithFields(List<OrderItem> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", quantity - " + printList.get(i).getQuantity() + ".");
    }

}
