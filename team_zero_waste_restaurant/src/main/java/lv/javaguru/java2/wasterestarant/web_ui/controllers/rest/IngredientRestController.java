package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;

import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientRestController {

    @Autowired
    private SearchIngredientService searchIngredientService;

    @Autowired
    private AddDishIngredientService addDishIngredientService;


    @GetMapping(path = "/search", produces = "application/json")
    public SearchIngredientResponse searchIngredientsResponse (@RequestParam String name) {
        SearchIngredientRequest request = new SearchIngredientRequest(name);
        return searchIngredientService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddDishIngredientResponse addIngredient(@RequestBody AddDishIngredientRequest addDishIngredientRequest) {
        return addDishIngredientService.execute(addDishIngredientRequest);
    }
}
