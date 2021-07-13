package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class OrmLotRepositoryImpl implements LotRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLot(Lot lot) {
        sessionFactory.getCurrentSession().save(lot);

    }

    @Override
    public boolean deleteLotById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Lot where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Lot> getAllLots() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Lot b", Lot.class)
                .getResultList();
    }

    @Override
    public List<Lot> searchByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Lot b where name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Lot> searchByPrice(BigDecimal price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Lot b where start_price = :price");
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Lot> searchByNameAndPrice(String name, BigDecimal price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Lot b where name = :name AND start_price = :price");
        query.setParameter("name", name);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public Optional<Lot> getById(Long id) {
        Lot lot = sessionFactory.getCurrentSession().get(Lot.class, id);
        if(lot == null){
            return Optional.empty();
        } else {
            return Optional.of(lot);
        }
    }
}
