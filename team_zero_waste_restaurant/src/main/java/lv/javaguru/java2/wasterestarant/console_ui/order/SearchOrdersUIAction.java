package lv.javaguru.java2.wasterestarant.console_ui.order;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.SearchOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.SearchOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class SearchOrdersUIAction implements UIAction {

    @Autowired
    private SearchOrdersService searchOrdersService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client ID: ");
        Long clientID = getLong(scanner);
        System.out.println("Enter date (format: \"dd, MM, yyyy\") : ");
        Date orderDate = getDate(scanner);

        SearchOrdersRequest request = new SearchOrdersRequest(clientID, orderDate);
        SearchOrdersResponse response = searchOrdersService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getOrders().forEach(Order::toString);
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
