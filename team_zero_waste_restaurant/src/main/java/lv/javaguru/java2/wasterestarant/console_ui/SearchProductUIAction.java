package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.SearchProductService;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;
import java.util.Scanner;

public class SearchProductUIAction implements UIAction {

    private SearchProductService searchProductService;

    public SearchProductUIAction(SearchProductService searchProductService) {
        this.searchProductService = searchProductService;
    }

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
        Integer pageNumber = scanner.nextInt();
        System.out.println("Enter page size: ");
        Integer pageSize = scanner.nextInt();
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
                printDishWithFields(printList, i);
            }
            System.out.println("_____________end_____________");
        }
    }

    private void printDishWithFields(List<Product> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() + ", quantity - "
                + printList.get(i).getQuantity() + ", price - " + printList.get(i).getPrice()
                + " \u0024, " + " with expiry date - " + printList.get(i).getExpiryDate());
    }
}
