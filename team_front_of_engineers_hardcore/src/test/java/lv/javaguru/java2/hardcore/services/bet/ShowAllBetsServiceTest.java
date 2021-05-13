package lv.javaguru.java2.hardcore.services.bet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.requests.bet.ShowAllBetsRequest;

@RunWith(MockitoJUnitRunner.class)
public class ShowAllBetsServiceTest {

	@Mock private BetDatabase betDatabase;

	@InjectMocks
	private ShowAllBetsService service;

	@Test
	public void shouldReturnAllBets() {
		ShowAllBetsRequest request = new ShowAllBetsRequest();

/*
		Bet bet1 = new Bet(BigDecimal.ONE, 1L);
		Bet bet2 = new Bet(BigDecimal.ONE, 2L);
		Mockito.when(betDatabase.getAllBets())
				.thenReturn(List.of(bet1, bet2));

		ShowAllBetsResponse response = service.execute(request);

		assertEquals(response.getShowAllBets().size(), 2);
*/
	}


}