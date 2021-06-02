package lv.javaguru.java2.wasterestarant.console_ui.dish;


import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;

import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.AddDishService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class AddDishUIAction implements UIAction {

    @Autowired
    private AddDishService addDishService;
    @Autowired
    private AddDishIngredientService addDishIngredientService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish name: ");
        String dishName = scanner.nextLine();
        System.out.println("Enter dish description: ");
        String dishDescription = scanner.nextLine();
        System.out.println("Enter dish type: ");
        String dishType = scanner.nextLine();
        System.out.println("Enter dish weight: ");
        Double dishWeight = getDouble(scanner);
        System.out.println("Enter dish price: ");
        Double dishPrice = getDouble(scanner);

        AddDishRequest request = new AddDishRequest(dishName, dishDescription, dishType, dishWeight, dishPrice);
        AddDishResponse response = addDishService.execute(request);


        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New dish id : " + response.getNewDish().getDishID());
            System.out.println("Your dish has been added to the list");
        }

        System.out.println("Enter ingredient: ");
        String ingredient = scanner.nextLine();
        System.out.println("Enter quantity: ");
        Double ingredientQuantity = getDouble(scanner);

        AddDishIngredientRequest requestDI = new AddDishIngredientRequest(ingredient, ingredientQuantity);
        AddDishIngredientResponse responseDI = addDishIngredientService.execute(requestDI);

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("Ingredient has been added to ingredient dish list");
            System.out.println("Enter \"stop\" to stop adding ingredients");
            String exit = scanner.nextLine();
            if (exit.equalsIgnoreCase("stop")) break;
            else{ execute();}
        }

        if (responseDI.hasErrors()) {
            responseDI.getErrors().forEach(coreError ->
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
