package lv.javaguru.java2.hardcore.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Lot {

    private String name;
    private BigDecimal startPrice;
    private Long id;
    private User user;


    public Lot(String name, BigDecimal startPrice, User user) {
        this.name = name;
        this.startPrice = startPrice;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", LotstartPrice=" + startPrice +
                ", LotId#=" + id +
                ", UserWhoMadeLot=" + user+
                '}';
    }
}
