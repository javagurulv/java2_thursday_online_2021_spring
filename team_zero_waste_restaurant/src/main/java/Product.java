import java.util.Date;
import java.util.Objects;

public class Product {
    private String name;
    private int quantity;
    private Date expiryDate;

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

        return quantity == product.quantity && name.equals(product.name) && expiryDate.equals(product.expiryDate);
    }

    @Override
    public int hashCode() {
        int hash;
        return hash = 8 * Objects.hash(name, quantity, expiryDate) + 15;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                '}';
    }

}


