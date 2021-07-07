package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.AddProductService;
import lv.javaguru.java2.wasterestarant.core.services.products.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private GetProductService getProductService;

    @Autowired
    private AddProductService addProductService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public GetProductResponse getProduct(@PathVariable Long id) {
        GetProductRequest request = new GetProductRequest(id);
        return getProductService.execute(request);
    }


    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
  //@JsonFormat(pattern="dd-MM-yyyy")
    public AddProductResponse addProduct(@RequestBody AddProductRequest request) {
        return addProductService.execute(request);
    }

}
