package lv.javaguru.java2.wasterestarant.domain;

import java.util.List;

public class Cart {

    private List<OrderItem> clientsWishlist;

    public Cart() {}

    public Cart(List<OrderItem> clientsWishlist) {
        this.clientsWishlist = clientsWishlist;
    }

    public List<OrderItem> getClientsWishlist() {
        return clientsWishlist;
    }

    public void setClientsWishlist(List<OrderItem> clientsWishlist) {
        this.clientsWishlist = clientsWishlist;
    }

}
