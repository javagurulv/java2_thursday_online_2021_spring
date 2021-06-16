package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesBySkillService;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesBySkillRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SearchEmployeesBySkillServiceTest {

    @Mock
    private ORMSkillRepository ormSkillRepository;

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
        Mockito.verifyNoInteractions(ormSkillRepository);
    }

    @Test
    public void testSuccessfullyFoundEmployees() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("Java");
        Skill skill = new Skill(1L, "Java");
        skill.getEmployees().add(new Employee(1L, "Aaa", "Bbb", 22, new EmployeeTitle("dev")));
        Mockito.when(ormSkillRepository.getSkillByName(request.getSkillName())).thenReturn(skill);
        SearchEmployeesBySkillResponse response = service.execute(request);
        assertThat(response.getEmployeeSet()).isEqualTo(Set.of(new Employee
                (1L, "Aaa", "Bbb", 22, new EmployeeTitle("dev"))));
    }

    @Test
    public void testNotYetAddedSkill() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("Java");
        Mockito.when(requestValidator.validate(request)).thenReturn(List.of(new CoreError("this skill", "is not added yet!")));
        SearchEmployeesBySkillResponse response = service.execute(request);
        assertThat(response.getErrors()).isEqualTo(List.of(new CoreError("this skill", "is not added yet!")));
    }
}