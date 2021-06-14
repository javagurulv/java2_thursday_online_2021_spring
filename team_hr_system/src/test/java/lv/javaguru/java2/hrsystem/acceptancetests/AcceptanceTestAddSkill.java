/*package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.DatabaseCleaner;
import lv.javaguru.java2.hrsystem.config.HRSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.database.jdbcrepos.SkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeeSkillsRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeeSkillsResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.skill.AddSkillService;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllEmployeeSkillsService;
import lv.javaguru.java2.hrsystem.core.services.skill.GetAllExistingSkillsService;
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
        getDatabaseCleaner().clean();
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

    public GetAllExistingSkillsService getAllExistingSkillsService() {
        return context.getBean(GetAllExistingSkillsService.class);
    }

    public SkillRepository getSkillRepository(){
        return context.getBean(SkillRepository.class);
    }

    public DatabaseCleaner getDatabaseCleaner() {
        return context.getBean(DatabaseCleaner.class);
    }

    @Test
    public void addSkillForExistingEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);

        GetAllExistingSkillsRequest getAllExistingSkillsRequest = new GetAllExistingSkillsRequest();
        GetAllExistingSkillsResponse getAllExistingSkillsResponse = getAllExistingSkillsService().execute(getAllExistingSkillsRequest);

        assertThat(getAllExistingSkillsResponse.getSkills()).isEqualTo(List.of(new Skill(1L, "Java")));
        assertThat(addSkillResponse.isEmployeeSkillAdded()).isTrue();
    }

    @Test
    public void addSkillForNonExistingEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddSkillRequest addSkillRequest = new AddSkillRequest(3L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        assertThat(addSkillResponse.isEmployeeSkillAdded()).isFalse();
        assertThat(addSkillResponse.getErrors()).isEqualTo(List.of(new CoreError("employee id", " does not exist")));
    }

    @Test
    public void addSkillAndShowSkillsPerEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("John", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 25);
        getAddEmployeeService().execute(addEmployeeRequest1);

        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        AddSkillRequest addSkillRequest1 = new AddSkillRequest(2L, "QA");
        AddSkillResponse addSkillResponse1 = getAddSkillService().execute(addSkillRequest1);
        AddSkillRequest addSkillRequest2 = new AddSkillRequest(2L, "Devops");
        AddSkillResponse addSkillResponse2 = getAddSkillService().execute(addSkillRequest2);

        GetAllEmployeeSkillsRequest getAllEmployeeSkillsRequest = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse getAllEmployeeSkillsResponse =
                getAllEmployeeSkillsService().execute(getAllEmployeeSkillsRequest);

        GetAllExistingSkillsRequest getAllExistingSkillsRequest = new GetAllExistingSkillsRequest();
        GetAllExistingSkillsResponse getAllExistingSkillsResponse = getAllExistingSkillsService().execute(getAllExistingSkillsRequest);

        assertThat(getAllExistingSkillsResponse.getSkills()).isEqualTo(List.of(new Skill(1L, "Java"),
                new Skill(2L, "QA"),
                new Skill(3L, "Devops")));

        assertThat(getAllEmployeeSkillsResponse.hasEmployeeSkills()).isTrue();
        assertThat(getAllEmployeeSkillsResponse.getEmployeeSkills()).isEqualTo(
                List.of(new EmployeeSkill(new Employee(1L), new Skill("Java")),
                        new EmployeeSkill(new Employee(2L), new Skill("QA")),
                        new EmployeeSkill(new Employee(2L), new Skill("Devops"))));
    }

    @Test
    public void testAddingAlreadyExistingSkill() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("Tom", "Smith", 22);
        getAddEmployeeService().execute(addEmployeeRequest);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 25);
        getAddEmployeeService().execute(addEmployeeRequest1);

        AddSkillRequest addSkillRequest = new AddSkillRequest(1L, "Java");
        AddSkillResponse addSkillResponse = getAddSkillService().execute(addSkillRequest);
        AddSkillRequest addSkillRequest1 = new AddSkillRequest(2L, "Java");
        AddSkillResponse addSkillResponse1 = getAddSkillService().execute(addSkillRequest1);

        AddSkillRequest addSkillRequest2 = new AddSkillRequest(2L, "Java");
        AddSkillResponse addSkillResponse2 = getAddSkillService().execute(addSkillRequest2);

        GetAllEmployeeSkillsRequest getAllEmployeeSkillsRequest = new GetAllEmployeeSkillsRequest();
        GetAllEmployeeSkillsResponse getAllEmployeeSkillsResponse = getAllEmployeeSkillsService().execute(getAllEmployeeSkillsRequest);

        GetAllExistingSkillsRequest getAllExistingSkillsRequest = new GetAllExistingSkillsRequest();
        GetAllExistingSkillsResponse getAllExistingSkillsResponse = getAllExistingSkillsService().execute(getAllExistingSkillsRequest);

        //check that already added skill is not added for that employee
        assertThat(addSkillResponse2.isEmployeeSkillAdded()).isFalse();

        //check employeeSkills - skills per each employee
        assertThat(getAllEmployeeSkillsResponse.getEmployeeSkills()).isEqualTo(
                List.of(new EmployeeSkill(new Employee(1L), new Skill("Java")),
                        new EmployeeSkill(new Employee(2L), new Skill("Java"))));

        //check skill list populated with newly added skills
        assertThat(getAllExistingSkillsResponse.getSkills()).isEqualTo(List.of(new Skill(1L, "Java")));
    }
}*/