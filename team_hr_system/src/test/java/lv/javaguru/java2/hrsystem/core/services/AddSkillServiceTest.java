package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.skill.AddSkillService;
import lv.javaguru.java2.hrsystem.core.services.validators.skill.AddSkillRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddSkillServiceTest {

    @Mock
   // private EmployeeSkillsRepository employeeSkillsRepository;
    private ORMEmployeeRepository ormEmployeeRepository;

    @Mock
    private ORMSkillRepository ormSkillRepository;
   // private SkillRepository skillRepository;

    @Mock
    private AddSkillRequestValidator validator;

    @InjectMocks
    private AddSkillService service;

    @Test
    public void testErrorsWhenIdAndSkillAreInvalid() {
        AddSkillRequest request = new AddSkillRequest(null, null);
        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("employee id", " Must not be empty!"));
            add(new CoreError("employee skill", " Must not be empty!"));
        }};
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddSkillResponse response = service.execute(request);
        assertThat(response.getErrors().size() == 2).isTrue();
        assertThat(response.getErrors().contains(
                new CoreError("employee id", " Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(
                new CoreError("employee skill", " Must not be empty!"))).isTrue();
        Mockito.verifyNoInteractions(ormEmployeeRepository);
        Mockito.verifyNoInteractions(ormSkillRepository);
    }

    @Test
    public void testErrorsWhenIdIsInvalid() {
        AddSkillRequest request = new AddSkillRequest(null, "DevOps");
        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("employee id", " Must not be empty!"));
        }};
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddSkillResponse response = service.execute(request);
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(
                new CoreError("employee id", " Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(ormEmployeeRepository);
        Mockito.verifyNoInteractions(ormSkillRepository);
    }

    @Test
    public void testErrorsWhenSkillIsInvalid() {
        AddSkillRequest request = new AddSkillRequest(1L, "");
        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("employee skill", " Must not be empty!"));
        }};
        Mockito.lenient().when(validator.validate(request)).thenReturn(errors);
        AddSkillResponse response = service.execute(request);
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(
                new CoreError("employee skill", " Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(ormEmployeeRepository);
        Mockito.verifyNoInteractions(ormSkillRepository);
    }

    @Test
    public void testErrorsWhenSkillIsNull() {
        AddSkillRequest request = new AddSkillRequest(1L, null);
        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("employee skill", " Must not be empty!"));
        }};
        Mockito.when(validator.validate(request)).thenReturn(errors);
        AddSkillResponse response = service.execute(request);
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(
                new CoreError("employee skill", " Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(ormEmployeeRepository);
        Mockito.verifyNoInteractions(ormSkillRepository);
    }

    @Test
    public void testSuccessfulAddingSkill() {
        AddSkillRequest request = new AddSkillRequest(1L, "Java");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormSkillRepository.saveSkill(new Skill(request.getSkillName()))).thenReturn(true);
        AddSkillResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.isEmployeeSkillAdded()).isTrue();
    }

    @Test
    public void testAddingAlreadyAddedSkill() {
        AddSkillRequest request = new AddSkillRequest(1L, "Java");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormSkillRepository.saveSkill(new Skill(request.getSkillName()))).thenReturn(false);
        AddSkillResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.isEmployeeSkillAdded()).isFalse();
    }

    @Test
    public void testAddingSkillWithNonExistingEmployee() {
        AddSkillRequest request = new AddSkillRequest(1L, "QA");
        Mockito.when(validator.validate(request)).thenReturn(List.of(
                new CoreError("employee id", " does not exist")));
        AddSkillResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(List.of(
                new CoreError("employee id", " does not exist")));
        Mockito.verifyNoInteractions(ormEmployeeRepository);
    }
}