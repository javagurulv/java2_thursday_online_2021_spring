//package lv.javaguru.java2.hardcore.services.bet;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import lv.javaguru.java2.hardcore.database.BetDatabase;
////import lv.javaguru.java2.hardcore.datamodels.Bet;
//import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
//import lv.javaguru.java2.hardcore.response.CoreError;
//import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;
//
//public class AddBetServiceTest {
//
//	private BetDatabase betDatabase;
//	private AddBetValidator validator;
//
//	private AddBetService service;
//
//	@Before
//	public void init() {
//		betDatabase = Mockito.mock(BetDatabase.class);
//		validator = Mockito.mock(AddBetValidator.class);
//		service = new AddBetService(betDatabase, validator);
//	}
//
//	@Test
//	public void shouldReturnResponseWithErrorsWhenRequestNotValid() {
//		AddBetRequest request = new AddBetRequest(null, null);
//
//		CoreError error = new CoreError("id", "mmm");
//		Mockito.when(validator.validate(request))
//			.thenReturn(List.of(error));
//
//		AddBetResponse response = service.execute(request);
//
//		assertTrue(response.hasErrors());
//		assertEquals(response.getErrors().size(), 1);
//		assertEquals(response.getErrors().get(0).getField(), "id");
//		assertEquals(response.getErrors().get(0).getMessage(), "mmm");
//	}
//
//	@Test
//	public void shouldReturnSuccessfulResponse(){
//		AddBetRequest request = new AddBetRequest(null, null);
//
//		Mockito.when(validator.validate(request))
//				.thenReturn(List.of());
//
//		AddBetResponse response = service.execute(request);
//
//		assertFalse(response.hasErrors());
//		assertNotNull(response.getNewBet());
//		Bet bet = response.getNewBet();
//
//		Mockito.verify(betDatabase).addBet(bet);
//	}
//
//
//}