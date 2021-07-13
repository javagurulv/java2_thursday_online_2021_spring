package lv.javaguru.java2.hardcore.core.requests.lot;

public class GetLotRequest {

    private Long id;

    public GetLotRequest() {
    }

    public GetLotRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
