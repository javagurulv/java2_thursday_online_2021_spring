package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchOffersService {
    private final Database database;
    private final SearchOffersValidator validator;

    public SearchOffersService(Database database, SearchOffersValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchOffersResponse execute(SearchOffersRequest request) {
        List<CoreError> errors = validator.validate(request);
        List<Offer> offers = database.searchOffers(request);
        offers = order(offers, request.getOrdering());

        return new SearchOffersResponse(errors, offers);
    }

    private List<Offer> order(List<Offer> offers, Ordering ordering) {
        if (ordering != null) {
            Comparator<Offer> comparator = getComparator(ordering.getOrderBy());

            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }

            return offers.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return offers;
        }
    }

    private Comparator<Offer> getComparator(String sortBy) {
        if ("type".equals(sortBy)) {
            return Comparator.comparing(Offer::getOfferType);
        } else if ("category".equals(sortBy)) {
            return Comparator.comparing(Offer::getPropertyCategory);
        } else if ("price".equals(sortBy)) {
            return Comparator.comparing(Offer::getPrice);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
