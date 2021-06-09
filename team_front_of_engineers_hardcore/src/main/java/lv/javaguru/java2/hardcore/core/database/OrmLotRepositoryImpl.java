package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
@Transactional
public class OrmLotRepositoryImpl implements LotRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLot(Lot lot) {

    }

    @Override
    public boolean deleteLotById(Long id) {
        return false;
    }

    @Override
    public List<Lot> getAllLots() {
        return null;
    }

    @Override
    public List<Lot> searchByName(String name) {
        return null;
    }

    @Override
    public List<Lot> searchByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<Lot> searchByNameAndPrice(String name, BigDecimal price) {
        return null;
    }
}
