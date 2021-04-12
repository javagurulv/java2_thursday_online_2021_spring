package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

public interface Database {

    void createAccount(User user);

    void logIn(User user);

    void createOffer(Offer offer);

    List<Offer> getAllOffers();

    boolean deleteOfferByID(int id);

    void deleteUser(User user);
}
