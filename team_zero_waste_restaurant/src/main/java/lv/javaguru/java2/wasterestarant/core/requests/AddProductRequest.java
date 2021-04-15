package lv.javaguru.java2.wasterestarant.core.requests;

import java.util.Date;

public class AddProductRequest {

    private String name;
    private Double quantity;
    private Double price;
    private Date date;

    public AddProductRequest(String name, Double quantity, Double price, Date date){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
