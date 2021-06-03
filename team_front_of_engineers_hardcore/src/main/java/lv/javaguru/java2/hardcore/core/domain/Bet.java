package lv.javaguru.java2.hardcore.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Bet {

    private BigDecimal bet;
    private Long betId;
    private Long userID;

    public Bet() {
    }

    public Bet(BigDecimal bet, Long betId, Long userID) {
        this.bet = bet;
        this.betId = betId;
        this.userID = userID;
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
        Bet bet = (Bet) o;
        return Objects.equals(betId, bet.betId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId);
    }

    @Override
    public String toString() {
        return "Bet " + bet + " eur" +
                ", LotID=" + betId +
                ", IdOfUserWhoMadeBet=" + userID+
                '}';
    }
}
