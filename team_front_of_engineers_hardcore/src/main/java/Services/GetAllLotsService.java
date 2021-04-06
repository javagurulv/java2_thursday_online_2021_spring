package Services;

import DataModels.Lot;
import Database.LotDatabase;

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
