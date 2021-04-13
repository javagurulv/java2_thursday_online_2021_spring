package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;

import java.util.ArrayList;
import java.util.List;

public class DeleteOfferService {
    Database database;

    public DeleteOfferService(Database database) {
        this.database = database;
    }

    public DeleteOfferResponse execute(DeleteOfferRequest deleteOfferRequest) {
        if (deleteOfferRequest.getId() == null) {
            CoreError error = new CoreError("id", "Must not be empty!");
            List<CoreError> errors = new ArrayList<>();
            errors.add(error);
            return new DeleteOfferResponse(errors);
        }

        boolean isOfferDeleted = database.deleteOfferByID(deleteOfferRequest.getId());

        return new DeleteOfferResponse(isOfferDeleted);
    }
}
