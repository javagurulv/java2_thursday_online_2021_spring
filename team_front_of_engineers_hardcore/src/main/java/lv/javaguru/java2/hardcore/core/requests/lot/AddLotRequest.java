package lv.javaguru.java2.hardcore.core.requests.lot;

import java.math.BigDecimal;

public class AddLotRequest {
    private String name;
    private BigDecimal price;

    public AddLotRequest() {
    }

    public AddLotRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
