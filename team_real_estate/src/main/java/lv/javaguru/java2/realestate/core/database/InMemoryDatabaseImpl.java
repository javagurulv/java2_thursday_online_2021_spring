package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//@Component
public class InMemoryDatabaseImpl implements UserRepository, OfferRepository {

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
    public boolean logIn(User user) {
        return users.contains(user);
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
    public boolean deleteUser(User user) {
        boolean isUserDeleted = false;
        Optional<User> userToDeleteOptional = users.stream()
                .filter(user1 -> user1.equals(user))
                .findFirst();
        if (userToDeleteOptional.isPresent()) {
            isUserDeleted = users.remove(userToDeleteOptional.get());
        }
        return isUserDeleted;
    }

    @Override
    public List<Offer> searchOffers(SearchOffersRequest request) {
        Predicate<Offer> offerTypePredicate = (a) ->
                request.getOfferType().equals("") || a.getOfferType().equals(request.getOfferType());

        Predicate<Offer> offerCategoryPredicate = (a) ->
                request.getOfferCategory().equals("") || a.getOfferCategory().equals(request.getOfferCategory());

        Predicate<Offer> offerPricePredicate = (a) ->
                request.getPrice() == 0.0 || a.getPrice().equals(request.getPrice());

        return offers.stream()
                .filter(offerTypePredicate.and(offerCategoryPredicate.and(offerPricePredicate)))
                .collect(Collectors.toList());
    }
    @Nullable
    @Override
    public User getUser(User user) {
        return null;
    }
}
