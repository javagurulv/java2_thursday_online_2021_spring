package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllOffersService {
    @Autowired
    private OfferRepository database;

    public GetAllOffersResponse execute(GetAllOffersRequest getAllOffersRequest) {
        return new GetAllOffersResponse(database.getAllOffers());
    }
}
