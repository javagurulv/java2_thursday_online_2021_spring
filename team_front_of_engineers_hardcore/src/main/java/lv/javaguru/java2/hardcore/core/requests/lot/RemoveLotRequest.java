package lv.javaguru.java2.hardcore.core.requests.lot;

public class RemoveLotRequest {

    private Long id;

    public RemoveLotRequest(Long id) {
        this.id = id;
    }

    public Long getLotIdToRemove() {
        return id;
    }
}
