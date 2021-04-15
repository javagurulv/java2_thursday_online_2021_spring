package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.core.services.GetAllProductsService;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetAllProductsUIAction implements UIAction{
    private GetAllProductsService getAllProductsService;

    public GetAllProductsUIAction(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @Override
    public void execute() {
        System.out.println("__________Product list__________");
        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = getAllProductsService.execute(request);
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
