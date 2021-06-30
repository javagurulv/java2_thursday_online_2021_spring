package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateOfferValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOfferService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private CreateOfferValidator validator;

    public CreateOfferResponse execute(CreateOfferRequest createOfferRequest) {
        List<CoreError> errors = validator.validate(createOfferRequest);
        if (!errors.isEmpty()) {
            return new CreateOfferResponse(errors);
        }
        Offer offer = buildOffer(createOfferRequest);
        offerRepository.createOffer(offer);
        return new CreateOfferResponse(offer);
    }

    private Offer buildOffer(CreateOfferRequest createOfferRequest) {
        return new Offer(
                createOfferRequest.getOfferType(),
                createOfferRequest.getOfferCategory(),
                createOfferRequest.getDescription(),
                createOfferRequest.getPrice());
    }

}
