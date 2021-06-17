package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.LotBets;

public interface LotBetsRepository {



    public void save(LotBets lotBets);

    public LotBets getById(Long id);
}
