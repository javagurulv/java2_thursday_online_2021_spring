package lv.javaguru.java2.wasterestarant.web_ui.controllers.rest;


import lv.javaguru.java2.wasterestarant.core.services.dish.*;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.requests.dish.*;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.responses.dish.*;
import lv.javaguru.java2.wasterestarant.core.GetRestaurantMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishRestController {

    @Autowired
    private AddDishService addDishService;

    @Autowired
    private GetAllDishesService getAllDishesService;

    @Autowired
    private GetDishByIdService getDishByIdService;

    @Autowired
    private RemoveDishService removeDishService;

    @Autowired
    private SearchDishesService searchDishesService;

    @Autowired
    private GetRestaurantMenuService getRestaurantMenuService;


    @GetMapping(path = "/{id}", produces = "application/json")
    public GetDishByIdResponse getDishById(@PathVariable Long id) {
        GetDishByIdRequest request = new GetDishByIdRequest(id);
        return getDishByIdService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddDishResponse addDish(@RequestBody AddDishRequest addDishRequest) {
        return addDishService.execute(addDishRequest);
    }

    @DeleteMapping(path = "/{dishNameToDelete}",
                   produces = "application/json")
    public RemoveDishResponse removeDish(@PathVariable String dishNameToDelete) {
        RemoveDishRequest removeDishRequest = new RemoveDishRequest(dishNameToDelete);
        return removeDishService.execute(removeDishRequest);
    }

    @GetMapping(path = "/search", produces = "application/json")
    public SearchDishesResponse searchDishesResponse (@RequestParam String name,
                                                      @RequestParam String type) {
        SearchDishesRequest request = new SearchDishesRequest(name, type);
        return searchDishesService.execute(request);
    }
    
    @GetMapping(path = "/getAllDishes", produces = "application/json")
    public GetAllDishesResponse response(){
        GetAllDishesRequest request = new GetAllDishesRequest();
        return getAllDishesService.execute(request);
    }

    @GetMapping(path = "/showMenu", produces = "application/json")
    public GetRestaurantMenuResponse getRestaurantMenu(){
        GetRestaurantMenuRequest request = new GetRestaurantMenuRequest();
        return getRestaurantMenuService.execute(request);
    }
}
