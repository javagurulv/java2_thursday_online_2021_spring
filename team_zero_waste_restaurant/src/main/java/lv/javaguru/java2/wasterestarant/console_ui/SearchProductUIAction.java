package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.SearchProductService;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.Scanner;

public class SearchProductUIAction implements UIAction {

    private SearchProductService searchProductService;

    public SearchProductUIAction(SearchProductService searchProductService) {
        this.searchProductService = searchProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product's name to search: ");
        String name = scanner.nextLine();

        SearchProductRequest request = new SearchProductRequest(name);
        SearchProductResponse response = searchProductService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() +
                    " " + coreError.getMessage()));
        } else {
            response.getProducts().forEach(Product::toString);
        }
    }
}
