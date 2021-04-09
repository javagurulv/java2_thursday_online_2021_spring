package lv.javaguru.java2.hardcore.services;

import lv.javaguru.java2.hardcore.database.LotDatabase;

public class RemoveLotService {
    private LotDatabase lotDatabase;

    public RemoveLotService(LotDatabase lotDatabase) {
        this.lotDatabase = lotDatabase;
    }

    public void execute(Long lotId){

        lotDatabase.deleteLotById(lotId);


    }
}
