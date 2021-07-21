package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;

import lv.javaguru.java2.wasterestarant.core.services.products.*;
import lv.javaguru.java2.wasterestarant.core.requests.product.*;
import lv.javaguru.java2.wasterestarant.core.responses.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private GetProductService getProductService;

    @Autowired
    private AddProductService addProductService;

    @Autowired
    private GetAllProductsService getAllProductsService;

    @Autowired
    private RemoveProductService removeProductService;

    @Autowired
    private SearchProductService searchProductService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetProductResponse getProduct(@PathVariable Long id) {
        GetProductRequest request = new GetProductRequest(id);
        return getProductService.execute(request);
    }


    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddProductResponse addProduct(@RequestBody AddProductRequest request) {
        return addProductService.execute(request);
    }

    @GetMapping(path = "/getAllProducts", produces = "application/json")
    public GetAllProductsResponse response(){
        GetAllProductsRequest request = new GetAllProductsRequest();
        return getAllProductsService.execute(request);
    }

    @DeleteMapping(path = "/{productNameToRemove}", produces = "application/json")
    public RemoveProductResponse deleteProduct(@PathVariable String productNameToRemove) {
        RemoveProductRequest request = new RemoveProductRequest(productNameToRemove);
        return removeProductService.execute(request);
    }

    @GetMapping(path = "/search/{name}", produces = "application/json")
    public SearchProductResponse searchProductsResponse (@PathVariable String name) {
        SearchProductRequest request = new SearchProductRequest(name);
        return searchProductService.execute(request);
    }

}
