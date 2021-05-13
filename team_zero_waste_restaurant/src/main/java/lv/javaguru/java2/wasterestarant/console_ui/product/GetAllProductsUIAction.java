package lv.javaguru.java2.wasterestarant.console_ui.product;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.GetAllProductsService;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Elena
@Component
public class GetAllProductsUIAction implements UIAction {
    @Autowired
    private GetAllProductsService getAllProductsService;

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
