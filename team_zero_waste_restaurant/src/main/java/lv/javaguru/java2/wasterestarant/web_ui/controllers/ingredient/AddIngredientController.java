package lv.javaguru.java2.wasterestarant.web_ui.controllers.ingredient;


import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.AddDishIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddIngredientController {

    @Autowired
    private AddDishIngredientService addDishIngredientService;

        @GetMapping(value = "/addIngredient")
    public String showAddIngredientPage(ModelMap modelMap) {
        modelMap.addAttribute("requestIngredient", new AddDishIngredientRequest());
        return "/addIngredient";
    }
        @PostMapping("/addIngredient")
    public String processAddIngredientRequest(@ModelAttribute(value = "requestIngredient") AddDishIngredientRequest requestIngredient,
                                        ModelMap modelMap) {
        AddDishIngredientResponse responseIngredient = addDishIngredientService.execute(requestIngredient);
        if (responseIngredient.hasErrors()) {
            modelMap.addAttribute("errors", responseIngredient.getErrors());
        }
        return "/addIngredient";
    }
}
