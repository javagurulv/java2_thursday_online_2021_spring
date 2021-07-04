package lv.javaguru.java2.hardcore.core.requests.bet;

public class GetAllBetsForLotByLotIdRequest {

    private Long id;


    public GetAllBetsForLotByLotIdRequest() {
    }

    public GetAllBetsForLotByLotIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
