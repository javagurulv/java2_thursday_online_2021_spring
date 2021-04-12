package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;

public class DeleteOfferService {
    Database database;

    public DeleteOfferService(Database database) {
        this.database = database;
    }

    public DeleteOfferResponse execute(DeleteOfferRequest deleteOfferRequest) {
        Offer offer = new Offer(
                deleteOfferRequest.getOfferType(),
                deleteOfferRequest.getPropertyCategory(),
                deleteOfferRequest.getDescription(),
                deleteOfferRequest.getPrice());
        database.deleteOffer(offer);
        return new DeleteOfferResponse(offer);
    }
}
