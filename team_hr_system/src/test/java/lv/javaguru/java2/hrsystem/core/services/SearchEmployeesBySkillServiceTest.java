package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesBySkillRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SearchEmployeesBySkillServiceTest {

    @Mock
    private Database database;

    @Mock
    private SearchEmployeesBySkillRequestValidator requestValidator;

    @InjectMocks
    private SearchEmployeesBySkillService service;

    @Test
    public void testResponseWithErrors() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest(null);
        Mockito.when(requestValidator.validate(request)).thenReturn(List.of(
                new CoreError("skill name", "Must not be empty!")));
        SearchEmployeesBySkillResponse response = service.execute(request);
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(List.of(
                new CoreError("skill name", "Must not be empty!")));
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void testSuccessfullyFoundEmployees() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("Java");
        Mockito.when(requestValidator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getEmployeesBySkill(new Skill(request.getSkillName()))).thenReturn(List.of(new Employee(1L)));
        Mockito.when(database.getAllEmployees()).thenReturn(List.of(new Employee(1L, "John", "Smith", 25)));
        SearchEmployeesBySkillResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getEmployees()).isEqualTo(List.of(
                new Employee(1L, "John", "Smith", 25)));
    }
}