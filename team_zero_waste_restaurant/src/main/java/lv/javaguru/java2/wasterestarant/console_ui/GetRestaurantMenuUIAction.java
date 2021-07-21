package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.GetRestaurantMenuService;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Nataliya - in process
@Component
public class GetRestaurantMenuUIAction implements UIAction{
    @Autowired
    private GetRestaurantMenuService getRestaurantMenuService;

    @Override
    public void execute() {
        System.out.println("__________Restaurant Menu__________");
        GetRestaurantMenuRequest request = new GetRestaurantMenuRequest();
        GetRestaurantMenuResponse response = getRestaurantMenuService.execute(request);
        List<Dish> printList = response.getRestaurantMenu();
        for (int i = 0; i < printList.size(); i++) {
            printRestaurantMenuWithFields(printList, i);
        }
        System.out.println("_____________end_____________");
    }

    private void printRestaurantMenuWithFields(List<Dish> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", " + printList.get(i).getDescription() +
                ", " + printList.get(i).getType() +
                ", price - " + printList.get(i).getPrice() + " \u0024, " +
                "weight - " + printList.get(i).getWeight() + " grams.");
    }

}
