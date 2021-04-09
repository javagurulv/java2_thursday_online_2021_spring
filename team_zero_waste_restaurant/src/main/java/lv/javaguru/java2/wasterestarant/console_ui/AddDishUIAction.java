package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.AddDishService;

public class AddDishUIAction implements UIAction {
    private AddDishService addDishService;

    public AddDishUIAction(AddDishService addDishService) {
        this.addDishService = addDishService;
    }

    @Override
    public void execute() {
        addDishService.execute();
    }
}
