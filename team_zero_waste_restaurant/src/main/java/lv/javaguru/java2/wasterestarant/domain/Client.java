package lv.javaguru.java2.wasterestarant.domain;

import java.util.List;
import java.util.Objects;

public class Client {

    private String name;
    private boolean isRegistered;
    private long clientID;
    private List<OrderItem> wishlist;

    public Client() {
    }

    public Client(String name, boolean isRegistered) {
        this.name = name;
        this.isRegistered = isRegistered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public List<OrderItem> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<OrderItem> wishlist) {
        this.wishlist = wishlist;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return isRegistered == client.isRegistered &&
                clientID == client.clientID &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isRegistered, clientID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", isRegistered=" + isRegistered +
                //", clientID=" + clientID +
                '}';
    }

}
