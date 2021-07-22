package lv.javaguru.java2.wasterestarant.core.services.dish.validators;

import lv.javaguru.java2.wasterestarant.core.requests.dish.GetDishByIdRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class GetDishByIdValidatorTest {
    @InjectMocks
    private GetDishByIdValidator validator;

    @Test
    public void shouldReturnErrorIfIdIsEmpty(){
        GetDishByIdRequest request = new GetDishByIdRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "id");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnEmptyErrorList() {
        GetDishByIdRequest request = new GetDishByIdRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }
}