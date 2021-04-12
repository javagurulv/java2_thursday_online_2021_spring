package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;

public class DeleteOfferService {
    Database database;

    public DeleteOfferService(Database database) {
        this.database = database;
    }

    public DeleteOfferResponse execute(DeleteOfferRequest deleteOfferRequest) {
        boolean isOfferDeleted = database.deleteOfferByID(deleteOfferRequest.getId());

        return new DeleteOfferResponse(isOfferDeleted);
    }
}
