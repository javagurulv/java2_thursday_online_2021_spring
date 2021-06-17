package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Component
@Transactional
public class OrmBetRepositoryImpl implements BetRepository, BetGetter {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBet(Bet bet) {
        sessionFactory.getCurrentSession().save(bet);

    }

    @Override
    public boolean deleteBetById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Bet where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Bet> getAllBets() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Bet b", Bet.class)
                .getResultList();
    }

    @Override
    public List<Bet> getBetListByLotId (Long id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Bet b where lot_id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
