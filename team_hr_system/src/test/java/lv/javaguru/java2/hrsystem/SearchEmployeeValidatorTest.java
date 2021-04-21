package lv.javaguru.java2.hrsystem;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.SearchEmployeesRequestValidator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchEmployeeValidatorTest {

    private SearchEmployeesRequestValidator validator = new SearchEmployeesRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenSecondNameNullTest() {
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER",null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldNotReturnErrorsWhenTitleNullTest() {
        SearchEmployeesRequest request = new SearchEmployeesRequest(null,"null");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenTitleAndSecondNameNullTest() {
        SearchEmployeesRequest request = new SearchEmployeesRequest(null,null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
        assertEquals(errors.get(1).getField(), "title");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }
}
