package lv.javaguru.java2.wasterestarant.console_ui.product;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.SearchProductService;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class SearchProductUIAction implements UIAction {

    @Autowired
    private SearchProductService searchProductService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product's name to search: ");
        String name = scanner.nextLine();
        System.out.println("Enter ordering parameter: BBD - for 'best before date', Q - for quantity.");
        String orderBy = scanner.nextLine();
        System.out.println("Enter ordering direction: ASC for ascending or DESC for descending:");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter page number: ");
        Integer pageNumber = validatePagingInput(scanner);
        System.out.println("Enter page size: ");
        Integer pageSize = validatePagingInput(scanner);
        Paging paging = new Paging(pageNumber, pageSize);

        SearchProductRequest request = new SearchProductRequest(name, ordering, paging);
        SearchProductResponse response = searchProductService.execute(request);


        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() +
                    " " + coreError.getMessage()));
        } else {
            System.out.println("__________Product list__________");
            List<Product> printList = response.getProducts();
            for (int i = 0; i < printList.size(); i++) {
                printProductWithFields(printList, i);
            }
            System.out.println("_____________end_____________");
        }
    }

    private void printProductWithFields(List<Product> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() + ", quantity - "
                + printList.get(i).getQuantity() + ", price - " + printList.get(i).getPrice()
                + " \u0024, " + " with expiry date - " + printList.get(i).getExpiryDate());
    }

    private Integer validatePagingInput(Scanner scanner) {
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            return null;
        }
    }
}
