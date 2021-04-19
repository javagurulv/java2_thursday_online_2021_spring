package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;

import java.util.List;

public class SearchOffersService {
    private final Database database;
    private final SearchOffersValidator validator;

    public SearchOffersService(Database database,SearchOffersValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchOffersResponse execute(SearchOffersRequest request) {
        List<CoreError> errors = validator.validate(request);
        List<Offer> offers = database.searchOffers(request);
        return new SearchOffersResponse(errors,offers);
    }
}
