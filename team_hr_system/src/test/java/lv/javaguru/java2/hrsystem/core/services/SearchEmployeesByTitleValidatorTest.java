package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SearchEmployeesByTitleValidatorTest {
    private final SearchEmployeesByTitleRequestValidator validator = new SearchEmployeesByTitleRequestValidator();

    @Test
    public void testValidTitle() {
        SearchEmployeesByTitleRequest request = new SearchEmployeesByTitleRequest("BA");
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testInValidTitle() {
        SearchEmployeesByTitleRequest request = new SearchEmployeesByTitleRequest("BaA");
        assertThat(validator.validate(request))
                .contains(new CoreError("invalid title - BaA", " Must be selected from the pre-defined set!"));
    }

    @Test
    public void testEmptyTitle() {
        SearchEmployeesByTitleRequest request = new SearchEmployeesByTitleRequest("");
        assertThat(validator.validate(request))
                .contains(new CoreError("employee title", "Must not be empty!"));
    }
}