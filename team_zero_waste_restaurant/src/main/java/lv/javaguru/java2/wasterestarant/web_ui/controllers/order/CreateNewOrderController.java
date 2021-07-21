package lv.javaguru.java2.wasterestarant.web_ui.controllers.order;

import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.CreateNewOrderResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateNewOrderController {

    @Autowired
    private CreateNewOrderService createNewOrderService;

    @GetMapping(value = "/createNewOrder")
    public String showCreateNewOrderPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new CreateNewOrderRequest());
        return "createNewOrder";
    }

    @PostMapping("/createNewOrder")
    public String processCreateNewOrderRequest(@ModelAttribute(value = "request") CreateNewOrderRequest request,
                                               ModelMap modelMap) {
        CreateNewOrderResponse response = createNewOrderService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "createNewOrder";
        } else {
            return "/createNewOrder";
        }
    }

}
