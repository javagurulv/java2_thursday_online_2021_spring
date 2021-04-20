package lv.javaguru.java2.hardcore.datamodels;

import java.math.BigDecimal;
import java.util.Objects;

public class Lot {

    private String name;
    private BigDecimal startPrice;
    private Long id;

    public Lot(String name, BigDecimal startPrice) {
        this.name = name;
        this.startPrice = startPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot that = (Lot) o;
        return Objects.equals(name, that.name) && Objects.equals(startPrice, that.startPrice) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startPrice, id);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "name='" + name + '\'' +
                ", startPrice=" + startPrice +" eur"+
                ", lotID=" + id +
                '}';
    }
}
