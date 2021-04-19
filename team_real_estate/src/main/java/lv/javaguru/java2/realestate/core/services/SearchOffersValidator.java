package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchOffersValidator {

    public List<CoreError> validate(SearchOffersRequest request) {
        return new ArrayList<>(validateSearchFields(request));
    }

    private List<CoreError> validateSearchFields(SearchOffersRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmptyString(request.getOfferType())
                && isEmptyString(request.getOfferCategory())
                && isEmptyDouble(request.getPrice()))
        {
            errors.add(new CoreError("Type", "Must not be empty!"));
            errors.add(new CoreError("Category", "Must not be empty!"));
            errors.add(new CoreError("Price", "Must not be empty"));
        }
        return errors;
    }

    private boolean isEmptyString(String aString) {
        return aString == null || aString.isEmpty();
    }

    private boolean isEmptyDouble(Double aDouble) {
        return aDouble == null || aDouble == 0.0;
    }

}
