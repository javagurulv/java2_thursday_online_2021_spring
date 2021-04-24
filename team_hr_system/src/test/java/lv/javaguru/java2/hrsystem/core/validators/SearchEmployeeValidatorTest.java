package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesRequestValidator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class SearchEmployeeValidatorTest {

    private SearchEmployeesRequestValidator validator = new SearchEmployeesRequestValidator();

    @Test
    public void shouldNotReturnError() {
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER", "null");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }

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

    @Test
    public void testInValidTitleEmptyName() {
        SearchEmployeesRequest request = new SearchEmployeesRequest("Baa", "");
        List<CoreError> exp = new ArrayList<>(){{
            add(new CoreError("invalid title - " + request.getEmployeeTitle(), " Must be selected from the pre-defined set!"));
        }};
        List<CoreError> act = validator.validate(request);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    public void shouldReturnErrorsWhenPageNumberContainNotValidValueTest() {
        Paging paging = new Paging(0, 1);
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER", "null", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPageSizeContainNotValidValueTest() {
        Paging paging = new Paging(1, 0);
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER", "null", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberAreEmpty() {
        Paging paging = new Paging(null, 1);
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER", "null", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeAreEmpty() {
        Paging paging = new Paging(1, null);
        SearchEmployeesRequest request = new SearchEmployeesRequest("HR_MANAGER", "null", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }
}