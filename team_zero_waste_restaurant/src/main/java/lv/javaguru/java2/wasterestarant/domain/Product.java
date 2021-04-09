package lv.javaguru.java2.wasterestarant.domain;

import java.util.Date;
import java.util.Objects;


public class Product {

    private String name;
    private int quantity;
    private double price;
    private Date expiryDate;

    public Product() { }

    public Product(String name, int quantity, double price, Date expiryDate) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(expiryDate, product.expiryDate);
    }

    @Override
    public int hashCode() {
        int hash;
        return hash = 8 * Objects.hash(name, quantity, price, expiryDate) + 15;
    }

    @Override
    public String toString() {
        return "lv.javaguru.java2.realestate.domain.Product : " + name + ", quantity : " + quantity + ", price : " + price +
                ", expiryDate : " + expiryDate ;
    }

}


