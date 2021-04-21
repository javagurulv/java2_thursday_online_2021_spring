package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.SearchDishesService;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.Scanner;
//Elena
public class SearchDishesUIAction implements UIAction{
    private SearchDishesService searchDishesService;

    public SearchDishesUIAction(SearchDishesService searchDishesService) {
        this.searchDishesService = searchDishesService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.println("Enter dish type: ");
        String type = scanner.nextLine();
        System.out.println("Enter dish price: ");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter orderBy (name||type||price): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);
        SearchDishesRequest request = new SearchDishesRequest(name, type, price, ordering, paging);
        SearchDishesResponse response = searchDishesService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getDishes().forEach(Dish::toString);
        }
    }
}
