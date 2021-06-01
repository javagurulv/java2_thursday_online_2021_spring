package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeSkillsRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GetAllEmployeeSkillsServiceTest {
    @Mock
    private EmployeeSkillsRepository employeeSkillsRepository;

    @InjectMocks
    private GetAllEmployeeSkillsService service;

    @Test
    public void testReturnAllEmployeeSkills() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        List<EmployeeSkill> exp = List.of(
                new EmployeeSkill(new Employee(1L), new Skill("DevOps")),
                new EmployeeSkill(new Employee(2L), new Skill("Java")));
        Mockito.when(employeeSkillsRepository.getAllEmplSkills()).thenReturn(exp);
        GetAllEmployeeSkillsResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getEmployeeSkills()).isEqualTo(exp);
    }
}