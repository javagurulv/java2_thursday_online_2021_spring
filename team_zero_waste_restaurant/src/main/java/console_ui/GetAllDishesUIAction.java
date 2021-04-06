package console_ui;

import services.GetAllDishesService;

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
