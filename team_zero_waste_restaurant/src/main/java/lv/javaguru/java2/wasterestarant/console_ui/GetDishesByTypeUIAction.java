package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.requests.GetDishByTypeRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetDishByTypeResponse;
import lv.javaguru.java2.wasterestarant.core.services.GetDishesByTypeService;
import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;
import java.util.Scanner;
// AndrejsB
public class GetDishesByTypeUIAction implements UIAction {

    private GetDishesByTypeService getDishesByTypeService;

    public GetDishesByTypeUIAction(GetDishesByTypeService getDishesByTypeService) {
        this.getDishesByTypeService = getDishesByTypeService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dish type to show (starter, soup, main, pasta, or desert): ");
        String dishType = scanner.nextLine();
        GetDishByTypeRequest request = new GetDishByTypeRequest(dishType);
        GetDishByTypeResponse response = getDishesByTypeService.execute(request);
        System.out.println("__________Dishes by type__________");
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() +
                    " " + coreError.getMessage()));
        } else {
            List<Dish> printList = response.getDishesType();
            for (int i = 0; i < printList.size(); i++) {
                printDishWithFields(printList, i);
            }
            System.out.println("________________end_______________");
        }
    }
    private void printDishWithFields(List<Dish> printList, int i) {
        System.out.println((i + 1) + ". " + printList.get(i).getName() +
                ", " + printList.get(i).getDescription() +
                //", " + printList.get(i).getProductList() +
                ", " + printList.get(i).getType() +
                ", price - " + printList.get(i).getPrice() + " \u0024, " +
                "weight - " + printList.get(i).getWeight() + " grams.");
    }
}
