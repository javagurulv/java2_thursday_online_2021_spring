package lv.javaguru.java2.wasterestarant.console_ui.dish;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.requests.dish.GetAllDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetAllDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.GetAllDishesService;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
//Elena
public class GetAllDishesUIAction implements UIAction {

    private GetAllDishesService getAllDishesService;

    public GetAllDishesUIAction(GetAllDishesService getAllDishesService) {
        this.getAllDishesService = getAllDishesService;
    }

    @Override
    public void execute() {
        System.out.println("__________Dish list__________");
        GetAllDishesRequest request = new GetAllDishesRequest();
        GetAllDishesResponse response = getAllDishesService.execute(request);
        List<Dish> printList = response.getDishes();
        for (int i = 0; i < printList.size(); i++) {
            printDishWithFields(printList, i);
        }
        System.out.println("_____________end_____________");
    }
    private void printDishWithFields(List<Dish> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", " + printList.get(i).getDescription() +
                ", " + printList.get(i).getType() +
                ", price - " + printList.get(i).getPrice() + " \u0024, " +
                "weight - " + printList.get(i).getWeight() + " grams.");
    }

}
