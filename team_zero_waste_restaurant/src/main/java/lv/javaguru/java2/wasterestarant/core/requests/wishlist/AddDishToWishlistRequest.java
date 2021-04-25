package lv.javaguru.java2.wasterestarant.core.requests.wishlist;

//Nataliya

public class AddDishToWishlistRequest {

    private String name;
    private int quantity;

    public AddDishToWishlistRequest(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return  name;
    }

    public int getQuantity() {
        return  quantity;
    }

}
