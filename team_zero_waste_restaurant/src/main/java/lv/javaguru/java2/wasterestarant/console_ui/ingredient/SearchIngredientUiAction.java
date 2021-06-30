package lv.javaguru.java2.wasterestarant.console_ui.ingredient;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class SearchIngredientUiAction implements UIAction {

    @Autowired
    private SearchIngredientService searchIngredientService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ingredient Name: ");
        String ingredientName = scanner.nextLine();

        System.out.println("Enter the dishID, which ingredients you need: ");
        Long dishID = scanner.nextLong();

        System.out.println("Order by name or quantity? (Enter \"N\" for name or \"Q\" for quantity)");
        String orderBy1 = scanner.nextLine();
        String orderBy = scanner.nextLine();
        System.out.println("Order in ascending or descending direction? (Enter \"A\" for ascending or \"D\" for Descending)");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);
        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);


        SearchIngredientRequest request = new SearchIngredientRequest(ingredientName, dishID, ordering, paging);
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
        System.out.println((i + 1) + ". " + printList.get(i).getName() + ", quantity - " + printList.get(i).getQuantity());
    }

}