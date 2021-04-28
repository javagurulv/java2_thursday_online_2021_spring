package lv.javaguru.java2.realestate.core.requests;

public class DeleteOfferRequest {
    private final Integer id;

    public DeleteOfferRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
