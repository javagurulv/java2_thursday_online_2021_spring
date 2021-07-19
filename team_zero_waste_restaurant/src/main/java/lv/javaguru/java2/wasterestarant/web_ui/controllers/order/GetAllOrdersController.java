package lv.javaguru.java2.wasterestarant.web_ui.controllers.order;

import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.GetAllOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllOrdersController {

    @Autowired
    private GetAllOrdersService getAllOrdersService;

    @GetMapping(value = "/getAllOrders")
    public String getAllOrders(ModelMap modelMap) {
        GetAllOrdersResponse response = getAllOrdersService.execute(new GetAllOrdersRequest());

        modelMap.addAttribute("Orders", response.getOrders());
        return "/getAllOrders";
    }

}
