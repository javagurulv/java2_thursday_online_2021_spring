package lv.javaguru.java2.hardcore.requests.lot;

import java.math.BigDecimal;

public class AddLotRequest {
    private String name;
    private BigDecimal price;

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
}
