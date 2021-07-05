package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

//@Component
public class JdbcDatabaseImpl implements UserRepository, OfferRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //TODO User id
    @Override
    public void createAccount(User user) {
        String sql = "INSERT INTO registered_user (username, password, email) "
                + "VALUES (?, ?, ?)";

        Object[] args = new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public boolean logIn(User user) {
        String sql = "SELECT username, password FROM registered_user WHERE " +
                "username = '" + user.getUsername() + "' AND " +
                "password = '" + user.getPassword() + "'";
        return user.equals(jdbcTemplate.query(sql, new UserRowMapper()).get(0));
    }

    @Override
    public void createOffer(Offer offer) {
        String sql = "INSERT INTO offer (type, category, description, price)"
                + "VALUES (?, ?, ?, ?)";

        Object[] args = new Object[]{
                offer.getOfferType(),
                offer.getOfferCategory(),
                offer.getDescription(),
                offer.getPrice()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Offer> getAllOffers() {
        String sql = "SELECT * FROM offer";
        return jdbcTemplate.query(sql, new OfferRowMapper());
    }

    @Override
    public boolean deleteOfferByID(int id) {
        String sql = "DELETE FROM offer WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    //TODO sql join table delete
    @Override
    public boolean deleteUser(User user) {
        Integer userID = jdbcTemplate.queryForObject("SELECT id FROM registered_user WHERE " +
                "username = '" + user.getUsername() + "' AND " +
                "password = '" + user.getPassword() + "'", Integer.class);


        List<Integer> userOffersList = jdbcTemplate.query("SELECT offer_id FROM user_offers " +
                "WHERE registered_user_id = '" + userID + "'", new UserOffersIDsRowMapper());

        for (Integer integer : userOffersList) {
            deleteOfferByID(integer);
        }

        String sql = "DELETE FROM registered_user WHERE username =? AND password = ?";
        Object[] args = new Object[]{
                user.getUsername(),
                user.getPassword()
        };
        return jdbcTemplate.update(sql, args) == 1;
    }

    //TODO input to null

    @Override
    public List<Offer> searchOffers(SearchOffersRequest request) {
        List<String> strings = new ArrayList<>();

        if (!"".equals(request.getOfferType())) {
            strings.add("type = '" + request.getOfferType() + "'");
        }
        if (!"".equals(request.getOfferCategory())) {
            strings.add("category = '" + request.getOfferCategory() + "'");
        }
        if (0.0 != (request.getPrice())) {
            strings.add("price = '" + request.getPrice() + "'");
        }

        String sql = "SELECT * FROM offer WHERE " + String.join(" AND ", strings);

        return jdbcTemplate.query(sql, new OfferRowMapper());
    }

    @Nullable
    @Override
    public User getUser(User user) {
        return null;
    }
}
