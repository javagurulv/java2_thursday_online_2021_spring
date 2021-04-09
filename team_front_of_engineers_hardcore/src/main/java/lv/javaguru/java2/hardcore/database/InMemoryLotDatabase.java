package lv.javaguru.java2.hardcore.database;

import lv.javaguru.java2.hardcore.datamodels.Lot;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLotDatabase implements LotDatabase {


    private List<Lot> lots = new ArrayList<>();

    @Override
    public void saveLot(Lot lot) {
        long leftLimit = 10L;
        long rightLimit = 1000000L;
        Long randomId = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        lot.setId(randomId);
        lots.add(lot);
    }

    @Override
    public void deleteLotById(Long id) {
        lots.removeIf(lot -> lot.getId().equals(id));

    }

    @Override
    public List<Lot> getAllLots() {
        return lots;
    }
}
