package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.Ordering;
import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesRequestValidator;
import org.junit.Test;

import java.util.List;

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
    public void shouldReturnErrorWhenOrderDirectionIsEmptyTest() {
        Ordering ordering = new Ordering("title", null);
        SearchEmployeesRequest request = new SearchEmployeesRequest("DEVELOPER", "Name", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByIsEmptyTest() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchEmployeesRequest request = new SearchEmployeesRequest("DEVELOPER", "Name", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByContainsNotValidValueTest() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchEmployeesRequest request = new SearchEmployeesRequest("DEVELOPER", "Name", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'name' or 'title' only!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionContainNotValidValueTest() {
        Ordering ordering = new Ordering("title", "notValidValue");
        SearchEmployeesRequest request = new SearchEmployeesRequest("DEVELOPER", "Name", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldReturnTwoOrderingErrorsWhenOrderByAndOrderDirectionContainsNotValidValuesTest() {
        Ordering ordering = new Ordering(null, "notValidValue");
        SearchEmployeesRequest request = new SearchEmployeesRequest("DEVELOPER", "Name", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
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