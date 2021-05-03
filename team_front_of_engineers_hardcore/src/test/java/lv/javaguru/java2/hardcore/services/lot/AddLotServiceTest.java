package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;
import lv.javaguru.java2.hardcore.services.user.LoginValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
/*
public class AddLotServiceTest {

    private LotDatabase lotDatabase;
    private AddLotValidator lotValidator;
    //private AddLotService service;
    private LoginService loginService;


    @Before
    public void init() {
        lotDatabase = Mockito.mock(LotDatabase.class);
        lotValidator = Mockito.mock(AddLotValidator.class);
       // loginService = Mockito.mock(LoginService.class);
        //service = new AddLotService(lotDatabase,lotValidator, loginService);


    }

    @Test
    public void shoudReturntValidatorErrors() {
        CoreError error = new CoreError("test1","test1");
        AddLotRequest request = new AddLotRequest(null, null);

        Mockito.when(lotValidator.validate(request)).thenReturn(List.of(error))

        AddLotResponse response = service.execute(request);

        //assertTrue(response.hasErrors());

    }
}*/