package lv.javaguru.java2.hardcore.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Lot {

    private String name;
    private BigDecimal startPrice;
    private Long id;
    private Long userID;

    public Lot() {
    }

    public Lot(String name, BigDecimal startPrice, Long userID) {
        this.name = name;
        this.startPrice = startPrice;
        this.userID = userID;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return Objects.equals(id, lot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "LotName='" + name + '\'' +
                ", LotStartPrice=" + startPrice +
                ", LotID#=" + id +
                ", IdOfUserWhoMadeLot=" + userID+
                '}';
    }
}
