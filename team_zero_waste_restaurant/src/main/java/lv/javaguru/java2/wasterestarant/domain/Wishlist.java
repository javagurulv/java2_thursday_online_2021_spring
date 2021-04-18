package lv.javaguru.java2.wasterestarant.domain;

import java.util.List;
import java.util.Objects;

public class Wishlist {

    private Long clientID;
    private List<OrderItem> selectedItems;

    public Wishlist() {
    }


    public Wishlist(Long clientID, List<OrderItem> selectedItems) {
        this.clientID = clientID;
        this.selectedItems = selectedItems;
    }


    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long client) {
        this.clientID = clientID;
    }

    public List<OrderItem> getSelectedDishes() {
        return selectedItems;
    }

    public void setSelectedDishes(List<OrderItem> selectedItems) {
        this.selectedItems = selectedItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlist)) return false;
        Wishlist wishlist = (Wishlist) o;
        return clientID.equals(wishlist.clientID) &&
                selectedItems.equals(wishlist.selectedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, selectedItems);
    }


    @Override
    public String toString() {
        return "Wishlist{" +
                "client=" + clientID +
                ", selectedDishes=" + selectedItems +
                '}';
    }
}
