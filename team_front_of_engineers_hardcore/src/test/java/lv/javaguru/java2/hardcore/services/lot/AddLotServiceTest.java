package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;
import lv.javaguru.java2.hardcore.services.user.LoginValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AddLotServiceTest {

    @Mock private LotDatabase lotDatabase;
    @Mock private Lot lot;
    @Mock private AddLotValidator lotValidator;
    @Mock private LoginService loginService;
    @InjectMocks
    private AddLotService service;


    @Test
    public void shouldReturntValidatorErrors() {
        List<CoreError> errors = new ArrayList<>();
        CoreError error = new CoreError("test1","test1");
        errors.add(error);
        AddLotRequest request = new AddLotRequest("abc", BigDecimal.ONE);

        Mockito.when(lotValidator.validate(request)).thenReturn(errors);

        AddLotResponse response = service.execute(request);

        assertTrue(response.hasErrors());

        assertEquals(response.getErrors().size(), 1);
    }

    @Test
    public void shouldReturnCorrectResponce() {
        AddLotRequest request = new AddLotRequest("abc", BigDecimal.ONE);
        Mockito.when(lotValidator.validate(request)).thenReturn(List.of());
        AddLotResponse response = service.execute(request);
        Lot lot = response.getNewLot();
        Mockito.verify(lotDatabase).saveLot(lot);
    }
}