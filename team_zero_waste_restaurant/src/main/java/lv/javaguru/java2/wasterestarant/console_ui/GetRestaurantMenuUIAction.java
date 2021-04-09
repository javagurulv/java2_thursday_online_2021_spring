package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.GetRestaurantMenuService;

public class GetRestaurantMenuUIAction implements UIAction{
    private GetRestaurantMenuService getRestaurantMenuService;

    public GetRestaurantMenuUIAction(GetRestaurantMenuService getRestaurantMenuService) {
        this.getRestaurantMenuService = getRestaurantMenuService;
    }

    @Override
    public void execute() {
        getRestaurantMenuService.execute();

    }
}
