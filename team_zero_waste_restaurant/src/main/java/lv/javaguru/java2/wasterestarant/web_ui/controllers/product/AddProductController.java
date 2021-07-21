package lv.javaguru.java2.wasterestarant.web_ui.controllers.product;

import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductController {

    @Autowired private AddProductService addProductService;


    @GetMapping(value = "/addProduct")
    public String showAddProductPage(ModelMap modelMap) {
        modelMap.addAttribute("productRequest", new AddProductRequest());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String processAddProductRequest(@ModelAttribute(value = "productRequest") AddProductRequest productRequest,
                                        ModelMap modelMap) {
        AddProductResponse response = addProductService.execute(productRequest);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "/addProduct";
        } else {
            return "/addProduct";
        }
    }



}
