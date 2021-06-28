package lv.javaguru.java2.wasterestarant.web_ui.controllers.product;

import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.GetAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllProductsController {

    @Autowired
    private GetAllProductsService getAllProductsService;

    @GetMapping(value = "/getAllProducts")
    public String getAllProducts(ModelMap modelMap) {
        GetAllProductsResponse response = getAllProductsService.execute(new GetAllProductsRequest());

        modelMap.addAttribute("Products", response.getProducts());
        return "/getAllProducts";
    }

}
