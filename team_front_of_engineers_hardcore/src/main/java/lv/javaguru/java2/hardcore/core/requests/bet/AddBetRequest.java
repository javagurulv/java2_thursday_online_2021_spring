package lv.javaguru.java2.hardcore.core.requests.bet;

import java.math.BigDecimal;

public class AddBetRequest {

    private Long id;
    private BigDecimal bet;

    public AddBetRequest(Long id, BigDecimal bet) {
        this.id = id;
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBet() {
        return bet;
    }
}
