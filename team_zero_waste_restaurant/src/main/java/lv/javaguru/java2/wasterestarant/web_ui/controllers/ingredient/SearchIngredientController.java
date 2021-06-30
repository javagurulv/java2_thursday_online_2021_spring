package lv.javaguru.java2.wasterestarant.web_ui.controllers.ingredient;


import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchIngredientController {
    @Autowired
    private SearchIngredientService service;

    @GetMapping(value="/searchIngredients")
    public String showSearchIngredientByName(ModelMap modelMap){
        modelMap.addAttribute("request", new SearchIngredientRequest());
        return "/searchIngredients";
    }

    @PostMapping("/searchIngredients")
    public String processSearchIngredientByName(@ModelAttribute(value="request")
                                                            SearchIngredientRequest request, ModelMap modelMap){
        SearchIngredientResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("ingredients", response.getIngredients());
        }
        return "/searchIngredients";
    }
}
