package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.Paging;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.validators.SearchOffersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchOffersService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private SearchOffersValidator validator;

    public SearchOffersResponse execute(SearchOffersRequest request) {
        List<CoreError> errors = validator.validate(request);
        List<Offer> offers = new ArrayList<>();

        if (errors.isEmpty()) {
            offers = offerRepository.searchOffers(request);
            /* offers = order(offers, request.getOrdering());
            offers = paging(offers, request.getPaging()); */
        }
        return new SearchOffersResponse(errors, offers);
    }

   /* private List<Offer> order(List<Offer> offers, Ordering ordering) {
        if (orderingEnabled && ordering != null) {
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
            return Comparator.comparing(Offer::getOfferCategory);
        } else if ("price".equals(sortBy)) {
            return Comparator.comparing(Offer::getPrice);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<Offer> paging(List<Offer> books, Paging paging) {
        if (pagingEnabled && paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return books.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return books;
        }
    } */
}
