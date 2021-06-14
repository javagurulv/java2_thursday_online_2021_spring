/*package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.config.HRSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesBySkillResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.skill.AddSkillService;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesBySkillService;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTestSearchBySkill {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(HRSystemConfiguration.class);
    }


    public AddEmployeeService getAddEmployeeService() {
        return context.getBean(AddEmployeeService.class);
    }

    public AddSkillService getAddSkillService() {
        return context.getBean(AddSkillService.class);
    }

    public SearchEmployeesBySkillService getSearchBySkillService(){
        return context.getBean(SearchEmployeesBySkillService.class);
    }

    @Test
    public void shouldReturnEmployeesWithSkill() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("Tom", "Smith", 25);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 44);

        getAddEmployeeService().execute(addEmployeeRequest);
        getAddEmployeeService().execute(addEmployeeRequest1);

        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "java");
        AddSkillRequest addSkillRequest1 = new AddSkillRequest(1L, "qa");
        AddSkillRequest addSkillRequest2 = new AddSkillRequest(2L, "qa");

        getAddSkillService().execute(addSkillRequest);
        getAddSkillService().execute(addSkillRequest1);
        getAddSkillService().execute(addSkillRequest2);

        SearchEmployeesBySkillRequest searchBySkillRequest = new SearchEmployeesBySkillRequest("java");
        SearchEmployeesBySkillResponse searchBySkillResponse = getSearchBySkillService().execute(searchBySkillRequest);

        assertThat(searchBySkillResponse.getEmployees().size() == 1).isTrue();
        assertThat(searchBySkillResponse.getEmployees()).isEqualTo(List.of(
                new Employee(1L, "Tom", "Smith", 25)));
    }

    @Test
    public void shouldReturnEmptyListWhenNoFoundSkill() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("Tom", "Smith", 25);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 44);

        getAddEmployeeService().execute(addEmployeeRequest);
        getAddEmployeeService().execute(addEmployeeRequest1);

        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "java");
        AddSkillRequest addSkillRequest1 = new AddSkillRequest(1L, "qa");
        AddSkillRequest addSkillRequest2 = new AddSkillRequest(2L, "qa");

        getAddSkillService().execute(addSkillRequest);
        getAddSkillService().execute(addSkillRequest1);
        getAddSkillService().execute(addSkillRequest2);

        SearchEmployeesBySkillRequest searchBySkillRequest = new SearchEmployeesBySkillRequest("devops");
        SearchEmployeesBySkillResponse searchBySkillResponse = getSearchBySkillService().execute(searchBySkillRequest);

        assertThat(searchBySkillResponse.getEmployees().isEmpty()).isTrue();
        assertThat(searchBySkillResponse.getEmployees()).isEqualTo(List.of());
    }
}*/