package lv.javaguru.java2.wasterestarant.web_ui.controllers.dish;

import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.AddDishResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.AddDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddDishController {

    @Autowired
    private AddDishService addDishService;


    @GetMapping(value = "/addDishToTheList")
    public String showAddDishPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddDishRequest());
        return "/addDishToTheList";
    }


    @PostMapping("/addDishToTheList")
    public String processAddDishRequest(@ModelAttribute(value = "request") AddDishRequest request,
                                        ModelMap modelMap) {
        AddDishResponse response = addDishService.execute(request);
        System.out.println(response.getNewDish().getDishID());
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        }
        return "/addDishToTheList";
    }

}
