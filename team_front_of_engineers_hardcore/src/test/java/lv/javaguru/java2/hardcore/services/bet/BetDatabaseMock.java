package lv.javaguru.java2.hardcore.services.bet;

import java.util.List;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.datamodels.Bet;

public class BetDatabaseMock implements BetDatabase {

	@Override
	public void addBet(Bet bet) {

	}

	@Override
	public boolean deleteBetById(Long id) {
		return false;
	}

	@Override
	public List<Bet> getAllBets() {
		return null;
	}
}
