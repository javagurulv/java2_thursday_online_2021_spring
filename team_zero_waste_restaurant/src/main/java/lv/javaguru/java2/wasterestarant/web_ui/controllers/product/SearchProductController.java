package lv.javaguru.java2.wasterestarant.web_ui.controllers.product;


import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchProductController {
    @Autowired
    private SearchProductService service;

    @GetMapping(value="/searchProducts")
    public String showSearchProductByName(ModelMap modelMap){
        modelMap.addAttribute("request", new SearchProductRequest());
        return "/searchProducts";
    }

    @PostMapping("/searchProducts")
    public String processSearchProductByName(@ModelAttribute(value="request")
                                                        SearchProductRequest request, ModelMap modelMap){
        SearchProductResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "/searchProducts";
        } else {
            modelMap.addAttribute("products", response.getProducts());
        }
        return "/searchProducts";
    }
}
