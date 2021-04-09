package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.GetAllDishesService;

public class GetAllDishesUIAction implements UIAction {

    private GetAllDishesService getAllDishesService;

    public GetAllDishesUIAction(GetAllDishesService getAllDishesService) {
        this.getAllDishesService = getAllDishesService;
    }

    @Override
    public void execute() {
        System.out.println("__________Dish list__________");
        getAllDishesService.execute();
        System.out.println("_____________end_____________");
    }
}
