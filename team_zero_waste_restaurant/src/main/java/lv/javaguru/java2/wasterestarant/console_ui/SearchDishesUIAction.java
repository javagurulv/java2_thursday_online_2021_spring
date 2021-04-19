package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.SearchDishesService;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.Scanner;

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

        SearchDishesRequest request = new SearchDishesRequest(name, type, price);
        SearchDishesResponse response = searchDishesService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getDishes().forEach(Dish::toString);
        }
    }
}
