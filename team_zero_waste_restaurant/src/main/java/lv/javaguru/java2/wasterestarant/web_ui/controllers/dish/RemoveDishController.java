package lv.javaguru.java2.wasterestarant.web_ui.controllers.dish;

import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.RemoveDishResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.RemoveDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RemoveDishController {

    @Autowired
    private RemoveDishService removeDishService;

    @GetMapping(value = "/removeDishFromTheList")
    public String showRemovedDishPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new RemoveDishRequest());
        return "/removeDishFromTheList";
    }

    @PostMapping(value = "/removeDishFromTheList")
    public String processDishRemoveRequest(@ModelAttribute(value = "request")
                                           RemoveDishRequest request, ModelMap modelMap) {
        RemoveDishResponse response = removeDishService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "/removeDishFromTheList";
        } else {
            return "/removeDishFromTheList";
        }
    }
}
