package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllEmployeeSkillsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GetAllEmployeeSkillsServiceTest {
    @Mock
    private ORMEmployeeRepository ormEmployeeRepository;

    @InjectMocks
    private GetAllEmployeeSkillsService service;

    @Test
    public void testReturnAllEmployeeSkills() {
        GetAllEmployeeSkillsRequest request = new GetAllEmployeeSkillsRequest();
        Employee e1 = new Employee(1L, "testFirst", "testLast", 25, null);
        e1.getSkills().add(new Skill(1L,"devops"));
        e1.getSkills().add(new Skill(2L,"testing"));

        Employee e2 = new Employee(2L, "testFirst2", "testLast2", 35, null);
        e2.getSkills().add(new Skill(3L,"sales"));

        Map<Employee, Set<Skill>> expected = new HashMap<>() {{
            put(e1, Set.of(new Skill(1L,"devops"), new Skill(2L,"testing")));
            put(e2, Set.of(new Skill(3L,"sales")));
        }};
        Mockito.when(ormEmployeeRepository.getAllEmployees()).thenReturn(List.of(e1, e2));
        GetAllEmployeeSkillsResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getEmployeeSetMap().equals(expected)).isTrue();
    }
}