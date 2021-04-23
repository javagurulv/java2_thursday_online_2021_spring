package lv.javaguru.java2.wasterestarant.console_ui.Product;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.Product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.Product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.Products.AddProductService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AddProductUIAction implements UIAction {
    private AddProductService addProductService;

    public AddProductUIAction(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product quantity: ");
        Double productQuantity = getDouble(scanner);
        System.out.println("Enter product price: ");
        Double productPrice = getDouble(scanner);
        System.out.println("Enter product expiry date (format: \"dd, MM, yyyy\") : ");
        Date productDate = getDate(scanner);

        AddProductRequest request = new AddProductRequest(productName, productQuantity, productPrice, productDate);
        AddProductResponse response = addProductService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("New product id : " + response.getNewProduct().getProductID());
            System.out.println("Your product has been added to the list");
        }
    }

    private Date getDate(Scanner scanner) {
        try{
            DateFormat format = new SimpleDateFormat("dd, MM, yyyy", Locale.GERMANY);
            return format.parse(scanner.nextLine());
        }
        catch(Exception e){
            return null;
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
