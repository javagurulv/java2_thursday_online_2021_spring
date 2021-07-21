package lv.javaguru.java2.wasterestarant.web_ui.controllers.dish;

import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.GetRestaurantMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetRestaurantMenuController {

    @Autowired
    private GetRestaurantMenuService getRestaurantMenuService;

    @GetMapping(value = "/getRestaurantMenu")
    public String getRestaurantMenu(ModelMap modelMap) {
        GetRestaurantMenuResponse response = getRestaurantMenuService.execute(new GetRestaurantMenuRequest());

        modelMap.addAttribute("dishes", response.getRestaurantMenu());
        return "/getRestaurantMenu";
    }

}
