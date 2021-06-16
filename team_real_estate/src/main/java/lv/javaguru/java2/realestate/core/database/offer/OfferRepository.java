package lv.javaguru.java2.realestate.core.database.offer;

import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;

import java.util.List;

public interface OfferRepository {

    List<Offer> getAllOffers();

    boolean deleteOfferByID(int id);

    void createOffer(Offer offer);

    List<Offer> searchOffers(SearchOffersRequest request);
}
