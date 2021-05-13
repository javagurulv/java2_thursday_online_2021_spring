package lv.javaguru.java2.hardcore.core.requests.bet;

public class RemoveBetRequest {

    private Long betIdToRemove;

    public RemoveBetRequest(Long betId) {
        this.betIdToRemove = betId;
    }

    public Long getBetIdToRemove() {
        return betIdToRemove;
    }
}
