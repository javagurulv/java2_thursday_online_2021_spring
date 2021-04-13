package lv.javaguru.java2.realestate.core.response;

import java.util.List;

public class DeleteOfferResponse extends CoreResponse {

    private boolean isOfferDeleted;

    public DeleteOfferResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteOfferResponse(boolean isOfferDeleted) {
        this.isOfferDeleted = isOfferDeleted;
    }

    public boolean isOfferDeleted() {
        return isOfferDeleted;
    }
}
