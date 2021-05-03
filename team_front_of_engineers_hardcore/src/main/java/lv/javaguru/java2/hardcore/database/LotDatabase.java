package lv.javaguru.java2.hardcore.database;

import lv.javaguru.java2.hardcore.domain.Lot;

import java.math.BigDecimal;
import java.util.List;

public interface LotDatabase {

    void saveLot(Lot lot);

    boolean deleteLotById(Long id);

    List<Lot> getAllLots();

    List<Lot> searchByName(String name);

    List<Lot> searchByPrice(BigDecimal price);

    List<Lot> searchByNameAndPrice(String name,BigDecimal price);

}
