package lv.javaguru.java2.hardcore.core.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lot_bets")
public class LotBets {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;


    @ManyToOne
    @JoinColumn(name = "bet_id", nullable = false)
    private Bet bet;

    public LotBets() {
    }

    public LotBets(Lot lot, Bet bet) {
        this.lot = lot;
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotBets lotBets = (LotBets) o;
        return Objects.equals(id, lotBets.id) && Objects.equals(lot, lotBets.lot) && Objects.equals(bet, lotBets.bet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, bet);
    }

    @Override
    public String toString() {
        return "LotBets{" +
                "id=" + id +
                ", lot=" + lot +
                ", bet=" + bet +
                '}';
    }
}
