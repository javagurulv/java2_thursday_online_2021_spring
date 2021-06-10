package lv.javaguru.java2.hardcore.core.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="user_bets")
public class Bet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="bet", nullable = false)
    private BigDecimal bet;
    @Column(name="lot_id", nullable = false)
    private Long lotId;
    @Column(name="user_id", nullable = false)
    private Long userID;

    public Bet() {
    }

    public Bet(BigDecimal bet, Long betId, Long userID) {
        this.bet = bet;
        this.lotId = betId;
        this.userID = userID;
    }

    public BigDecimal getBet() {
        return bet;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
        Bet bet = (Bet) o;
        return Objects.equals(lotId, bet.lotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotId);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", bet=" + bet +
                ", lotId=" + lotId +
                ", IdOfUserWhoMadeBet=" + userID +
                '}';
    }
}
