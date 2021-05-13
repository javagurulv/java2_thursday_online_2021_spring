package lv.javaguru.java2.wasterestarant.core.domain;

import java.util.Objects;

public class Client {

    private String name;
    private long clientID;
    private Cart cart;

    public Client() {
    }

    public Client(String name, Cart cart) {
        this.name = name;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return  clientID == client.clientID &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clientID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", clientID=" + clientID +
                '}';
    }

}
