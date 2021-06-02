//package lv.javaguru.java2.wasterestarant.console_ui.ingredient;
//
//import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
//import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
//import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
//import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.util.Scanner;
//
//@Component
//public class AddDishIngredientUiAction implements UIAction {
//
//    @Autowired
//    private AddDishIngredientService addDishIngredientService;
//
//    @Override
//    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter ingredient: ");
//        String ingredient = scanner.nextLine();
//        System.out.println("Enter quantity: ");
//        Double ingredientQuantity = getDouble(scanner);
//
//        AddDishIngredientRequest request = new AddDishIngredientRequest(ingredient, ingredientQuantity);
//        AddDishIngredientResponse response = addDishIngredientService.execute(request);
//
//        boolean isRunning = true;
//
//        while (isRunning) {
//
//            System.out.println("Ingredient has been added to ingredient dish list");
//            System.out.println("Enter \"stop\" to stop adding ingredients");
//            String exit = scanner.nextLine();
//            if (exit.equalsIgnoreCase("stop")) break;
//            else{ execute();}
//        }
//
//        if (response.hasErrors()) {
//            response.getErrors().forEach(coreError ->
//                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
//        } else {
//            System.out.println("Your ingredient has been added to the list");
//
//        }
//
//    }
//    private Double getDouble(Scanner scanner) {
//        try{
//            return Double.parseDouble(scanner.nextLine());
//        }
//        catch(Exception e){
//            return null;
//        }
//    }
//
//
//}
