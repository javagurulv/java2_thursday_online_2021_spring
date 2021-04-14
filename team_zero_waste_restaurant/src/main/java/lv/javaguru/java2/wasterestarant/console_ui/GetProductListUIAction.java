package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetDishListRequest;
import lv.javaguru.java2.wasterestarant.core.requests.GetProductListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetProductListResponse;
import lv.javaguru.java2.wasterestarant.core.services.GetProductListService;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetProductListUIAction implements UIAction{
    private GetProductListService getProductListService;

    public GetProductListUIAction(GetProductListService getProductListService) {
        this.getProductListService = getProductListService;
    }

    @Override
    public void execute() {
        System.out.println("__________Product list__________");
        GetProductListRequest request = new GetProductListRequest();
        GetProductListResponse response = getProductListService.execute(request);
        List<Product> printList = response.getProducts();
        for (int i = 0; i < printList.size(); i++) {
            printProductWithFields(printList, i);
        }
        System.out.println("_____________end_____________");
    }

    private void printProductWithFields(List<Product> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", " + printList.get(i).getQuantity() +
                ", price - " + printList.get(i).getPrice() + " \u0024, " +
                "expiry date - " + printList.get(i).getExpiryDate());
    }
}
