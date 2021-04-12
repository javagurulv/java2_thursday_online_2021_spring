package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.Offer;
import lv.javaguru.java2.realestate.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.response.CreateOfferResponse;

public class CreateOfferService {
    Database database;

    public CreateOfferService(Database database) {
        this.database = database;
    }

    public CreateOfferResponse execute(CreateOfferRequest createOfferRequest){
        Offer offer = new Offer(
                createOfferRequest.getOfferType(),
                createOfferRequest.getPropertyCategory(),
                createOfferRequest.getDescription(),
                createOfferRequest.getPrice());

        database.createOffer(offer);

        return new CreateOfferResponse(offer);
    }

}
