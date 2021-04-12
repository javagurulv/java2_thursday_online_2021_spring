package lv.javaguru.java2.realestate.core.requests;

public class DeleteOfferRequest {
    private final int id;

    public DeleteOfferRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
