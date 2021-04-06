package Services;

import DataModels.Lot;
import Database.LotDatabase;

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
