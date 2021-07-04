package lv.javaguru.java2.wasterestarant.core.requests;

public class GetRestaurantMenuRequest {
private boolean isInActiveMenu;

    public GetRestaurantMenuRequest() {
    }

    public GetRestaurantMenuRequest(boolean isInActiveMenu) {
        this.isInActiveMenu = isInActiveMenu;
    }

    public boolean isInActiveMenu() {
        return isInActiveMenu;
    }

    public void setInActiveMenu(boolean inActiveMenu) {
        isInActiveMenu = inActiveMenu;
    }
}
