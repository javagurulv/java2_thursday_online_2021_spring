package lv.javaguru.java2.wasterestarant.core.domain;

import java.util.Date;
import java.util.Objects;


public class Product {
    private long productID;
    private String name;
    private Double quantity;
    private Double price;
    private Date expiryDate;

    public Product(long productID) {
        this.productID = productID;
    }

    public Product(String name, Double quantity, Double price, Date expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
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

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
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
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                '}';
    }
}


