package lv.javaguru.java2.hardcore.requests.lot;

import java.math.BigDecimal;

public class SearchLotByNameOrPriceRequest {

    private String name;

    private BigDecimal price;

    public SearchLotByNameOrPriceRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isPriceProvided() {
        return this.price != null && !this.price.equals(BigDecimal.ZERO);
    }
}




