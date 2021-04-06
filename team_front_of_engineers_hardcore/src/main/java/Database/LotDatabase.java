package Database;

import DataModels.Lot;

import java.util.List;

public interface LotDatabase {

    void saveLot(Lot lot);

    void deleteLotById(Long id);

    List<Lot> getAllLots();
}
