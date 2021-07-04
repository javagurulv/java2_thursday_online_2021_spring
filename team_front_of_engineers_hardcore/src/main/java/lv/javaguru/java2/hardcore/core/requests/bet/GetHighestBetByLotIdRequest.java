package lv.javaguru.java2.hardcore.core.requests.bet;

public class GetHighestBetByLotIdRequest {

    private Long id;

    public GetHighestBetByLotIdRequest() {
    }

    public GetHighestBetByLotIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
