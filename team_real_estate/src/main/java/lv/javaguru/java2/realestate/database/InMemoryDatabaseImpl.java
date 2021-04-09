package lv.javaguru.java2.realestate.database;

import lv.javaguru.java2.realestate.domain.Offer;
import lv.javaguru.java2.realestate.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {

    private static final List<User> users = new ArrayList<>();
    private static final List<Offer> offers = new ArrayList<>();


    @Override
    public void createAccount(User user) {
        users.add(user);
        users.get(users.size() - 1).setId(users.size() + 1);

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
        offers.add(offer);
        System.out.println("Offer created");
    }

    @Override
    public List<Offer> viewAllOffers() {
        return offers;
    }

    @Override
    public void deleteOffer(Offer offer) {
        offers.remove(offer);
        System.out.println("Offer removed");
    }

    @Override
    public void deleteAccount(User user) {
        users.remove(user);
    }

}
