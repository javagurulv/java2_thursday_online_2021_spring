package lv.javaguru.java2.realestate.core.response;

public class DeleteOfferResponse {
    boolean isOfferDeleted;

    public DeleteOfferResponse(boolean isOfferDeleted) {
        this.isOfferDeleted = isOfferDeleted;
    }

    public boolean isOfferDeleted() {
        return isOfferDeleted;
    }
}
