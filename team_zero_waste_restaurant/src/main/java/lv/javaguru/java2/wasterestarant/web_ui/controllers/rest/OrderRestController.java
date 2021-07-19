package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;


import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetOrderByIdRequest;
import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.CreateNewOrderResponse;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetOrderByIdResponse;
import lv.javaguru.java2.wasterestarant.core.responses.order.SearchOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import lv.javaguru.java2.wasterestarant.core.services.order.GetAllOrdersService;
import lv.javaguru.java2.wasterestarant.core.services.order.GetOrderByIdService;
import lv.javaguru.java2.wasterestarant.core.services.order.SearchOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderRestController {


        @Autowired
        private GetOrderByIdService getOrderByIdService;

        @Autowired
        private CreateNewOrderService createNewOrderService;

        @Autowired
        private GetAllOrdersService getAllOrdersService;

        @Autowired
        private SearchOrdersService searchOrdersService;

        @GetMapping(path = "/{id}", produces = "application/json")
        public GetOrderByIdResponse getOrderById(@PathVariable Long id) {
            GetOrderByIdRequest request = new GetOrderByIdRequest(id);
            return getOrderByIdService.execute(request);
        }

        @PostMapping(path = "/",
                consumes = "application/json",
                produces = "application/json")
        public CreateNewOrderResponse createNewOrder(@RequestBody CreateNewOrderRequest request) {
            return createNewOrderService.execute(request);
        }

        @GetMapping(path = "/getAllOrders", produces = "application/json")
        public GetAllOrdersResponse response(){
            GetAllOrdersRequest request = new GetAllOrdersRequest();
            return getAllOrdersService.execute(request);
        }


        @GetMapping(path = "/search/{clientID, orderDate}", produces = "application/json")
        public SearchOrdersResponse searchOrdersResponse (@PathVariable Long clientID, Date orderDate) {
            SearchOrdersRequest request = new SearchOrdersRequest(clientID, orderDate);
            return searchOrdersService.execute(request);
        }

}
