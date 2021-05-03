package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;

import java.util.List;

public class LotDatabaseMock implements LotDatabase {

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
}
