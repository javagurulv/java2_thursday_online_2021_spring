package real_estate_app;

import java.util.List;

public interface Database {

    void createAccount(User user);
    void logIn(User user);
    void createOffer(Offer offer);
    List<Offer> viewAllOffers();
}
