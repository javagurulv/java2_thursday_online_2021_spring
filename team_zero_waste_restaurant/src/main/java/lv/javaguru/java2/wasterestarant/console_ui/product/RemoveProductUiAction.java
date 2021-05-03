package lv.javaguru.java2.wasterestarant.console_ui.product;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.RemoveProductService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

import java.util.Scanner;

//AndrejsB
@DIComponent
public class RemoveProductUiAction implements UIAction {

    @DIDependency
    private RemoveProductService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name to remove: ");
        String dishNameToRemove = scanner.nextLine();
        RemoveProductRequest request = new RemoveProductRequest(dishNameToRemove);
        RemoveProductResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " +
                    coreError.getField() + " " + coreError.getField()));
        } else {
            if (response.isProductRemoved()) {
                System.out.println("Your product was succesfully removed from the list.");
            } else {
                System.out.println("Your product was not removed from the list. " +
                        "Please enter a valid name from the list.");
            }
        }
    }
}
