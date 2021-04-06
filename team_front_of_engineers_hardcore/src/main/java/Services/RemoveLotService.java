package Services;

import Database.LotDatabase;

public class RemoveLotService {
    private LotDatabase lotDatabase;

    public RemoveLotService(LotDatabase lotDatabase) {
        this.lotDatabase = lotDatabase;
    }

    public void execute(Long lotId){

        lotDatabase.deleteLotById(lotId);


    }
}
