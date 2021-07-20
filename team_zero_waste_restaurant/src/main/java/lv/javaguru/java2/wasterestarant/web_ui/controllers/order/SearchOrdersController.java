package lv.javaguru.java2.wasterestarant.web_ui.controllers.order;

import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.SearchOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.services.order.SearchOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchOrdersController {

    @Autowired
    private SearchOrdersService service;

    @GetMapping(value="/searchOrders")
    public String showSearchOrders(ModelMap modelMap){
        modelMap.addAttribute("request", new SearchOrdersRequest());
        return "/searchOrders";
    }

    @PostMapping("/searchOrders")
    public String processSearchOrder(@ModelAttribute(value="request")
                                                        SearchOrdersRequest request, ModelMap modelMap){
        SearchOrdersResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "/searchOrders";
        } else {
            modelMap.addAttribute("orders", response.getOrders());
        }
        return "/searchOrders";
    }

}
