package lv.javaguru.java2.wasterestarant.console_ui.order;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.CreateNewOrderResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class CreateNewOrderUIAction implements UIAction {
    @Autowired
    private CreateNewOrderService createNewOrderService;

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client ID: ");
        Long clientID = getLong(scanner);
        System.out.println("Enter date for placing order (format: \"dd, MM, yyyy\") : ");
        Date orderDate = getDate(scanner);

        CreateNewOrderRequest request = new CreateNewOrderRequest(clientID, orderDate);
        CreateNewOrderResponse response = createNewOrderService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Your order has been added to the list");
        }

    }

    private Date getDate(Scanner scanner) {
        try{
            DateFormat format = new SimpleDateFormat("dd, MM, yyyy");
            return format.parse(scanner.nextLine());
        }
        catch(Exception e){
            return null;
        }
    }

    private Long getLong(Scanner scanner) {
        try{
            return Long.parseLong(scanner.nextLine());
        }
        catch(Exception e){
            return null;
        }
    }

}


