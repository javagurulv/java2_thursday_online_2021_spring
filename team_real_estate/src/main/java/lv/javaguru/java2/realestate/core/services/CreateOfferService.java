package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;

public class CreateOfferService {
    Database database;

    public CreateOfferService(Database database) {
        this.database = database;
    }

    public CreateOfferResponse execute(CreateOfferRequest createOfferRequest) {
        Offer offer = new Offer(
                createOfferRequest.getOfferType(),
                createOfferRequest.getPropertyCategory(),
                createOfferRequest.getDescription(),
                createOfferRequest.getPrice());

        database.createOffer(offer);

        return new CreateOfferResponse(offer);
    }

}
