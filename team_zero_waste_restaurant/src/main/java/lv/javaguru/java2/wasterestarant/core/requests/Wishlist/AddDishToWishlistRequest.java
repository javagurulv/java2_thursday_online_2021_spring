package lv.javaguru.java2.wasterestarant.core.requests.Wishlist;

//Nataliya

public class AddDishToWishlistRequest {

    private String name;
    private Long dishID;
    private int quantity;

    public AddDishToWishlistRequest(String name, Long dishID, int quantity) {
        this.name = name;
        this.dishID = dishID;
        this.quantity = quantity;
    }

    public String getName() {
        return  name;
    }

    public int getQuantity() {
        return  quantity;
    }

    public Long getDishID() {
        return dishID;
    }
}
