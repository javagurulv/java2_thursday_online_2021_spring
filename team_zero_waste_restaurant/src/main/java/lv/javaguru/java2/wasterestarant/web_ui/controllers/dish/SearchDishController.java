package lv.javaguru.java2.wasterestarant.web_ui.controllers.dish;


import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.SearchDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchDishController {

    @Autowired
    private SearchDishesService service;

    @GetMapping(value="/searchDishes")
    public String showSearchDishByNamePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchDishesRequest());
        return "/searchDish";
    }

    @PostMapping("/searchDishes")
    public String processSearchDishByNameRequest (@ModelAttribute(value="request")
                                                              SearchDishesRequest request, ModelMap modelMap) {
        SearchDishesResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("dishes", response.getDishes());
        }
        return "/searchDish";
    }
}
