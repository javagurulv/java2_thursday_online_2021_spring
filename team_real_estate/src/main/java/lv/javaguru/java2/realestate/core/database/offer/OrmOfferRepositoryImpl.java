package lv.javaguru.java2.realestate.core.database.offer;

import lv.javaguru.java2.realestate.core.database.user.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class OrmOfferRepositoryImpl implements OfferRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> getAllOffers() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT o FROM offer o", Offer.class)
                .getResultList();
    }

    @Override
    public boolean deleteOfferByID(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE offer WHERE id = :id");
        query.setParameter("id",id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public void createOffer(Offer offer) {
        sessionFactory.getCurrentSession().save(offer);
    }

    //TODO
    @Override
    public List<Offer> searchOffers(SearchOffersRequest request) {
        return null;
    }
}
