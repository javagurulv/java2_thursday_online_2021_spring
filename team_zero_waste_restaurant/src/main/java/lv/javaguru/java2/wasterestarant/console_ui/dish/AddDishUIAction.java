package lv.javaguru.java2.wasterestarant.console_ui.dish;


import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;

import lv.javaguru.java2.wasterestarant.core.services.dish.AddDishService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

import java.util.Scanner;
@DIComponent
public class AddDishUIAction implements UIAction {

    @DIDependency
    private AddDishService addDishService;

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
