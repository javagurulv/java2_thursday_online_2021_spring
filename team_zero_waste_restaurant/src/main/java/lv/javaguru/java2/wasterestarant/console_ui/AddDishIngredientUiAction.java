package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.AddDishIngredientService;

import java.util.Scanner;

public class AddDishIngredientUiAction implements UIAction {

    private AddDishIngredientService addDishIngredientService;

    public AddDishIngredientUiAction(AddDishIngredientService addDishIngredientService) {
        this.addDishIngredientService = addDishIngredientService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient: ");
        String ingredient = scanner.nextLine();
        System.out.println("Enter quantity: ");
        Double ingredientQuantity = getDouble(scanner);

        AddDishIngredientRequest request = new AddDishIngredientRequest(ingredient, ingredientQuantity);
        AddDishIngredientResponse response = addDishIngredientService.execute(request);

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("Ingredient has been added to ingredient dish list");
            System.out.println("Enter \"stop\" to stop adding ingredients");
            String exit = scanner.nextLine();
            if (exit.equalsIgnoreCase("stop")) break;
            else{ execute();}
        }

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Your ingredient has been added to the list");

        }

    }
    private Double getDouble(Scanner scanner) {
        try{
            return Double.parseDouble(scanner.nextLine());
        }
        catch(Exception e){
            return null;
        }
    }


}
