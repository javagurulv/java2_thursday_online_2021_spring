package lv.javaguru.java2.wasterestarant.core.requests.wishlist;

//Nataliya

public class AddDishToWishlistRequest {

    private Long clientID;
    private String dishName;
    private int quantity;

    public AddDishToWishlistRequest(Long clientID, String dishName, int quantity) {
        this.clientID = clientID;
        this.dishName = dishName;
        this.quantity = quantity;
    }

    public String getDishName() {
        return  dishName;
    }

    public int getQuantity() {
        return  quantity;
    }

    public Long getClientID() {
        return clientID;
    }
}
