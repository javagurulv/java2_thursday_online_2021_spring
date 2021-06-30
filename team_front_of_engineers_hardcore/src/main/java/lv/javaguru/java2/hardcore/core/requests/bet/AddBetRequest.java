package lv.javaguru.java2.hardcore.core.requests.bet;

import java.math.BigDecimal;

public class AddBetRequest {

    private Long id;
    private BigDecimal bet;

    public AddBetRequest() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }
}
