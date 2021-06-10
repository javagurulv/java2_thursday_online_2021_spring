package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmBetRepositoryImpl implements BetRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBet(Bet bet) {

    }

    @Override
    public boolean deleteBetById(Long id) {
        return false;
    }

    @Override
    public List<Bet> getAllBets() {
        return null;
    }
}
