package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetDishListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetDishListResponse;
import lv.javaguru.java2.wasterestarant.core.services.GetDishListService;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
//Elena
public class GetDishListUIAction implements UIAction {

    private GetDishListService getDishListService;

    public GetDishListUIAction(GetDishListService getDishListService) {
        this.getDishListService = getDishListService;
    }

    @Override
    public void execute() {
        System.out.println("__________Dish list__________");
        GetDishListRequest request = new GetDishListRequest();
        GetDishListResponse response = getDishListService.execute(request);
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
