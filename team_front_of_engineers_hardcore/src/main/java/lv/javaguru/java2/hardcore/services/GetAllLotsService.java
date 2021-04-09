package lv.javaguru.java2.hardcore.services;

import lv.javaguru.java2.hardcore.datamodels.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;

import java.util.List;

public class GetAllLotsService {
    private LotDatabase lotDatabase;

    public GetAllLotsService(LotDatabase lotDatabase) {
        this.lotDatabase = lotDatabase;
    }

    public List<Lot> execute() {
        return lotDatabase.getAllLots();
    }

}
