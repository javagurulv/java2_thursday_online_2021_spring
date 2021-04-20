package lv.javaguru.java2.hardcore.database;

import lv.javaguru.java2.hardcore.datamodels.Lot;

import java.util.List;

public interface LotDatabase {

    void saveLot(Lot lot);

    boolean deleteLotById(Long id);

    List<Lot> getAllLots();

}
