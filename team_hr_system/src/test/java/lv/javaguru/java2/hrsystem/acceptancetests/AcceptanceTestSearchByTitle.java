package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.requests.*;
import lv.javaguru.java2.hrsystem.core.services.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AcceptanceTestSearchByTitle {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(HumanResourcesSystemConfiguration.class);
    }

    public AddEmployeeWithTitleService getAddEmployeeWithTitleService() {
        return appContext.getBean(AddEmployeeWithTitleService.class);
    }

    public SearchEmployeesService getSearchEmployeeService() {
        return appContext.getBean(SearchEmployeesService.class);
    }

    @Test
    public void shouldReturnEmployeesWithThisTitle() {
        AddEmployeeWithTitleRequest addWithTitleRequest = new AddEmployeeWithTitleRequest(
                "Tom", "Smith", 25, "BA");

        AddEmployeeWithTitleRequest addWithTitleRequest1 = new AddEmployeeWithTitleRequest(
                "John", "Smith", 44, "BA");

        AddEmployeeWithTitleRequest addWithTitleRequest2 = new AddEmployeeWithTitleRequest(
                "One", "More", 44, "MANAGER");

        getAddEmployeeWithTitleService().execute(addWithTitleRequest);
        getAddEmployeeWithTitleService().execute(addWithTitleRequest1);
        getAddEmployeeWithTitleService().execute(addWithTitleRequest2);

        SearchEmployeesRequest searchRequest = new SearchEmployeesRequest(
                "BA", null, new Ordering("title", "ASCENDING"), new Paging(1, 2));
        SearchEmployeesResponse searchResponse = getSearchEmployeeService().execute(searchRequest);
        assertThat(searchResponse.getEmployees().size() == 2).isTrue();
        assertThat(searchResponse.getEmployees()).isEqualTo(List.of(
                new Employee(1L, "Tom", "Smith", 25),
                new Employee(2L,"John", "Smith", 44)));
    }
    @Test
    public void shouldReturnNoEmployeesWithThisTitle() {
        AddEmployeeWithTitleRequest addWithTitleRequest = new AddEmployeeWithTitleRequest(
                "Tom", "Smith", 25, "BA");

        AddEmployeeWithTitleRequest addWithTitleRequest1 = new AddEmployeeWithTitleRequest(
                "John", "Smith", 44, "BA");

        AddEmployeeWithTitleRequest addWithTitleRequest2 = new AddEmployeeWithTitleRequest(
                "One", "More", 44, "MANAGER");

        getAddEmployeeWithTitleService().execute(addWithTitleRequest);
        getAddEmployeeWithTitleService().execute(addWithTitleRequest1);
        getAddEmployeeWithTitleService().execute(addWithTitleRequest2);

        SearchEmployeesRequest searchRequest = new SearchEmployeesRequest(
                "QA_ENGINEER", null, new Ordering("title", "ASCENDING"), new Paging(1, 2));
        SearchEmployeesResponse searchResponse = getSearchEmployeeService().execute(searchRequest);
        assertThat(searchResponse.getEmployees().isEmpty()).isTrue();
        assertThat(searchResponse.getEmployees()).isEqualTo(List.of());
    }
}
