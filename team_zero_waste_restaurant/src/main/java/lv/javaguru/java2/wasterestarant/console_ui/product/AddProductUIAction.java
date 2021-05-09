package lv.javaguru.java2.wasterestarant.console_ui.product;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
@Component
public class AddProductUIAction implements UIAction {
    @Autowired
    private AddProductService addProductService;

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
