package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.Lot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
//@Component
public class InMemoryLotRepositoryImpl implements LotRepository {

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

    @Override
    public List<Lot> searchByName(String name) {
        return lots.stream().filter(lot -> lot.getName().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    @Override
    public List<Lot> searchByPrice(BigDecimal price) {
        return lots.stream().filter(lot -> lot.getStartPrice().compareTo(price) <= 0).collect(Collectors.toList());
    }

    @Override
    public List<Lot> searchByNameAndPrice(String name, BigDecimal price) {
        return lots.stream()
                .filter(lot -> lot.getName().toLowerCase(Locale.ROOT).startsWith(name.toLowerCase(Locale.ROOT)))
                .filter(lot -> lot.getStartPrice().compareTo(price) >= 0)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Lot> getById(Long id) {
        return Optional.empty();
    }
}
