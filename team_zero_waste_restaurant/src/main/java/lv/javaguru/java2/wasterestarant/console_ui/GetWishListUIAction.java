package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.GetWishlistService;

public class GetWishListUIAction implements UIAction{
    private GetWishlistService getWishlistService;

    public GetWishListUIAction(GetWishlistService getWishlistService) {
        this.getWishlistService = getWishlistService;
    }

    @Override
    public void execute() {
        System.out.println("__________Dish list__________");
        getWishlistService.execute();
        System.out.println("_____________end_____________");
    }
}
