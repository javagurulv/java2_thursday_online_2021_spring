package lv.javaguru.java2.wasterestarant.console_ui.Ingredient;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.Ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.Ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.Ingredient.SearchIngredientService;
import lv.javaguru.java2.wasterestarant.domain.Ingredient;

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

        SearchIngredientRequest request = new SearchIngredientRequest(ingredientName);
        SearchIngredientResponse response = searchIngredientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getIngredients().forEach(Ingredient::toString);
        }

    }

}
