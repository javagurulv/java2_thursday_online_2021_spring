package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;

import java.util.List;

public class CreateOfferService {

    private final Database database;
    private final CreateOfferValidator validator;

    public CreateOfferService(Database database,
                              CreateOfferValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public CreateOfferResponse execute(CreateOfferRequest createOfferRequest) {
        List<CoreError> errors = validator.validate(createOfferRequest);
        if (!errors.isEmpty()) {
            return new CreateOfferResponse(errors);
        }

        Offer offer = new Offer(
                createOfferRequest.getOfferType(),
                createOfferRequest.getPropertyCategory(),
                createOfferRequest.getDescription(),
                createOfferRequest.getPrice());

        database.createOffer(offer);

        return new CreateOfferResponse(offer);
    }

}
