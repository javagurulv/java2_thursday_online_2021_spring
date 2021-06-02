package lv.javaguru.java2.wasterestarant.console_ui.order;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.GetAllOrdersService;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllOrdersUIAction implements UIAction {
    @Autowired
    private GetAllOrdersService getAllOrdersService;

    @Override
    public void execute() {
        System.out.println("__________Order list__________");
        GetAllOrdersRequest request = new GetAllOrdersRequest();
        GetAllOrdersResponse response = getAllOrdersService.execute(request);
        List<Order> printList = response.getOrders();
        for (int i = 0; i < printList.size(); i++) {
            printOrderWithFields(printList, i);
        }
        System.out.println("_____________end_____________");
    }

    private void printOrderWithFields(List<Order> printList, int i) {
        System.out.println((i + 1) + ". Order ID: " + printList.get(i).getOrderID() +
                ", client ID: " + printList.get(i).getClientID() +
                ", order date: " + printList.get(i).getOrderDate());
    }

}
