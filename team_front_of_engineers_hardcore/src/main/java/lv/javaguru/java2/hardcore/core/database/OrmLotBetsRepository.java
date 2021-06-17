package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.LotBets;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrmLotBetsRepository implements LotBetsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(LotBets lotBets) {
        sessionFactory.getCurrentSession().save(lotBets);
    }

    @Override
    public LotBets getById(Long id) {
        return sessionFactory.getCurrentSession().get(LotBets.class, id);
    }
}
