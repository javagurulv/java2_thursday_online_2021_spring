package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.AddDishToWishlistService;

public class AddDishToWishlistUIAction implements UIAction{
    private AddDishToWishlistService addDishToWishlistService;

    public AddDishToWishlistUIAction(AddDishToWishlistService addDishToWishlistService) {
        this.addDishToWishlistService = addDishToWishlistService;
    }

    @Override
    public void execute() {
        addDishToWishlistService.execute();

    }
}
