package lv.javaguru.java2.realestate.database;

import lv.javaguru.java2.realestate.domain.Offer;
import lv.javaguru.java2.realestate.domain.User;

import java.util.List;

public interface Database {

    void createAccount(User user);
    void logIn(User user);
    void createOffer(Offer offer);
    List<Offer> viewAllOffers();
    void deleteOffer(Offer offer);
    void deleteAccount(User user);
}
