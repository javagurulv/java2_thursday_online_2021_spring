package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabaseImpl implements Database {

    private final List<User> users = new ArrayList<>();
    private final List<Offer> offers = new ArrayList<>();
    private int userIdCounter = 0;
    private int offerIdCounter = 0;


    @Override
    public void createAccount(User user) {
        user.setId(userIdCounter++);
        users.add(user);

    }

    @Override
    public void logIn(User user) {
        if (users.contains(user)) {
            System.out.println("Welcome " + user.getUsername());
        } else {
            System.out.println("Incorrect username or password");
        }
    }

    @Override
    public void createOffer(Offer offer) {
        offer.setId(offerIdCounter++);
        offers.add(offer);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offers;
    }

    @Override
    public boolean deleteOfferByID(int id) {
        boolean isOfferDeleted = false;
        Optional<Offer> offerToDeleteOptional = offers.stream()
                .filter(offer -> offer.getId() == id)
                .findFirst();
        if (offerToDeleteOptional.isPresent()) {
            isOfferDeleted = offers.remove(offerToDeleteOptional.get());
        }
        return isOfferDeleted;
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

}
