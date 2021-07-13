package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Lot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface LotRepository {

    void saveLot(Lot lot);

    boolean deleteLotById(Long id);

    List<Lot> getAllLots();

    List<Lot> searchByName(String name);

    List<Lot> searchByPrice(BigDecimal price);

    List<Lot> searchByNameAndPrice(String name, BigDecimal price);

    Optional<Lot> getById(Long id);

}
