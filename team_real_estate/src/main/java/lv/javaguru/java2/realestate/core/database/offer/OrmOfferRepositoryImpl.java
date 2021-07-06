package lv.javaguru.java2.realestate.core.database.offer;

import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrmOfferRepositoryImpl implements OfferRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> getAllOffers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM Offer o ", Offer.class)
                .getResultList();
    }

    @Override
    public boolean deleteOfferByID(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE Offer WHERE id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public void createOffer(Offer offer) {
        sessionFactory.getCurrentSession().save(offer);
    }

    @Override
    public List<Offer> searchOffers(SearchOffersRequest request) {
        String sql = "FROM Offer WHERE (:type is null or type = :type )" +
                "AND (:category is null or category = :category )" +
                "AND (:price is null or price = :price)";

        return sessionFactory.getCurrentSession()
                .createQuery(sql, Offer.class)
                .setParameter("type", request.getOfferType())
                .setParameter("category", request.getOfferCategory())
                .setParameter("price", request.getPrice())
                .getResultList();

    }
}
