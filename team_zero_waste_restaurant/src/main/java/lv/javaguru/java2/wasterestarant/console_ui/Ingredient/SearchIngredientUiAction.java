package lv.javaguru.java2.wasterestarant.console_ui.Ingredient;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.Ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.responses.Ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.Ingredient.SearchIngredientService;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;

import java.util.List;
import java.util.Scanner;

public class SearchIngredientUiAction implements UIAction {

    private SearchIngredientService searchIngredientService;

    public SearchIngredientUiAction(SearchIngredientService searchIngredientService) {
        this.searchIngredientService = searchIngredientService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ingredient Name: ");
        String ingredientName = scanner.nextLine();

        System.out.println("Order by name or quantity? (Enter \"N\" for name or \"Q\" for quantity)");
        String orderBy = scanner.nextLine();
        System.out.println("Order in ascending or descending direction? (Enter \"A\" for ascending or \"D\" for Descending)");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);


        SearchIngredientRequest request = new SearchIngredientRequest(ingredientName, ordering, paging);
        SearchIngredientResponse response = searchIngredientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("__________Ingredient list__________");
            List<Ingredient> printList = response.getIngredients();
            for (int i = 0; i < printList.size(); i++) {
                printIngredients(printList, i);
            }
            System.out.println("_____________end_____________");
        }
    }

    private void printIngredients(List<Ingredient> printList, int i) {
        System.out.println((i + 1) + ". "  + printList.get(i).getIngredient() + ", quantity - " + printList.get(i).getQuantity() );
    }

}
