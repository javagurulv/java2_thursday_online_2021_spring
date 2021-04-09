package lv.javaguru.java2.hardcore.services;

import lv.javaguru.java2.hardcore.datamodels.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;

import java.math.BigDecimal;


public class AddLotService {

    private LotDatabase lotDatabase;

    public AddLotService(LotDatabase lotDatabase) {

        this.lotDatabase = lotDatabase;
    }

    public void execute(String name, BigDecimal price) {
        Lot lot = new Lot(name, price);
        lotDatabase.saveLot(lot);

    }
}
