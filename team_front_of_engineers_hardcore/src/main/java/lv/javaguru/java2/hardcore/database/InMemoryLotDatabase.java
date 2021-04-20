package lv.javaguru.java2.hardcore.database;

import lv.javaguru.java2.hardcore.datamodels.Lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryLotDatabase implements LotDatabase {

    private Long nextId = 1L;
    private List<Lot> lots = new ArrayList<>();

    @Override
    public void saveLot(Lot lot) {
        lot.setId(nextId);
        nextId++;
        lots.add(lot);
    }

    @Override
    public boolean deleteLotById(Long id) {
        boolean isLotDeleted = false;
        Optional<Lot> lotToDeleteOpt = lots.stream().filter(lot -> lot.getId().equals(id)).findFirst();
        if (lotToDeleteOpt.isPresent()) {
            Lot lotToRemove = lotToDeleteOpt.get();
            isLotDeleted = lots.remove(lotToRemove);
        }
        return isLotDeleted;
    }

    @Override
    public List<Lot> getAllLots() {
        return lots;
    }


}
