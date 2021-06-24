package lv.javaguru.java2.wasterestarant.web_ui.controllers.dish;

import lv.javaguru.java2.wasterestarant.core.requests.dish.GetAllDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetAllDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.GetAllDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAllDishesController {

    @Autowired
    private GetAllDishesService getAllDishesService;

    @GetMapping(value = "/getAllDishes")
    public String getAllDishes(ModelMap modelMap) {
        GetAllDishesResponse response = getAllDishesService.execute(new GetAllDishesRequest());

        modelMap.addAttribute("dishes", response.getDishes());
        return "/getAllDishes";
    }

}
