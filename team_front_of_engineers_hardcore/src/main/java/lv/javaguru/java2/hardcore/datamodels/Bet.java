package lv.javaguru.java2.hardcore.datamodels;

import java.math.BigDecimal;
import java.util.Objects;

public class Bet {

    private BigDecimal bet;
    private Long betId;

    public Bet(BigDecimal bet, Long betId) {
        this.bet = bet;
        this.betId = betId;
    }


    public BigDecimal getBet() {
        return bet;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Objects.equals(betId, bet.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "bet=" + bet +
                ", ItemId=" + betId +
                '}';
    }
}
