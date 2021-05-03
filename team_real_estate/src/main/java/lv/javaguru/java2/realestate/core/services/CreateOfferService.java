package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateOfferValidator;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class CreateOfferService {

    @DIDependency
    private Database database;
    @DIDependency
    private CreateOfferValidator validator;

    public CreateOfferResponse execute(CreateOfferRequest createOfferRequest) {
        List<CoreError> errors = validator.validate(createOfferRequest);
        if (!errors.isEmpty()) {
            return new CreateOfferResponse(errors);
        }

        Offer offer = new Offer(
                createOfferRequest.getOfferType(),
                createOfferRequest.getOfferCategory(),
                createOfferRequest.getDescription(),
                createOfferRequest.getPrice());

        database.createOffer(offer);

        return new CreateOfferResponse(offer);
    }

}
