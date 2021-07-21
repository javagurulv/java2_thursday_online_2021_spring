package lv.javaguru.java2.wasterestarant.web_ui.controllers.ingredient;


import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchDishIngredientsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchDishIngredientsResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchDishIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchDishIngredientsController {
    @Autowired
    private SearchDishIngredientsService service;

    @GetMapping(value="/searchDishIngredients")
    public String showSearchIngredientsById(ModelMap modelMap){
        modelMap.addAttribute("request", new SearchDishIngredientsRequest());
        return "/searchDishIngredients";
    }

    @PostMapping("/searchDishIngredients")
    public String processSearchIngredientById(@ModelAttribute(value="request")
                                              SearchDishIngredientsRequest request, ModelMap modelMap){
        SearchDishIngredientsResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("dishIngredients", response.getIngredients());
        }
        return "/searchDishIngredients";
    }
}
