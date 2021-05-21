package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.config.HRSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.AddSkillService;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeeSkillsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTestAddSkill {

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

    public GetAllEmployeeSkillsService getAllEmployeeSkillsService() {
        return context.getBean(GetAllEmployeeSkillsService.class);
    }

    @Test
    public void addSkillForExistingEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        assertThat(addSkillResponse.isEmployeeSkillAdded()).isTrue();
    }

    @Test
    public void addSkillForNonExistingEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddSkillRequest addSkillRequest = new AddSkillRequest(2L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        assertThat(addSkillResponse.isEmployeeSkillAdded()).isFalse();
    }

    @Test
    public void addSkillAndShowAddSkills() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 25);
        getAddEmployeeService().execute(addEmployeeRequest1);

        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        AddSkillRequest addSkillRequest1 = new AddSkillRequest(2L, "QA");
        AddSkillResponse addSkillResponse1 = getAddSkillService().execute(addSkillRequest1);

        GetAllEmployeeSkillsRequest getAllEmployeeSkillsRequest = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse getAllEmployeeSkillsResponse =
                getAllEmployeeSkillsService().execute(getAllEmployeeSkillsRequest);


        assertThat(getAllEmployeeSkillsResponse.hasEmployeeSkills()).isTrue();
        assertThat(getAllEmployeeSkillsResponse.getEmployeeSkills()).isEqualTo(
                List.of(new EmployeeSkill(new Employee(1L), new Skill("Java")),
                        new EmployeeSkill(new Employee(2L), new Skill("QA"))));
    }
}
