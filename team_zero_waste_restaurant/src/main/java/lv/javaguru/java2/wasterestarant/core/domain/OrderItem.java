package lv.javaguru.java2.wasterestarant.core.domain;

public class OrderItem {

    private String dishName;
    private Long dishID;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(String name, int quantity) {
        this.dishName = name;
        this.dishID = getDishID();
        this.quantity = quantity;
    }

    public Long getDishID() {
        return dishID;
    }

    public void setDishID(Long dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String name) {
        this.dishName = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                ", name='" + dishName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
