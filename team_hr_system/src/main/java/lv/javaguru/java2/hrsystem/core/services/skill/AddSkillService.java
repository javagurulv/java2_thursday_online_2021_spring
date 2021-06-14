package lv.javaguru.java2.hrsystem.core.services.skill;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.skill.AddSkillRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSkillService {

    @Autowired
    // private EmployeeSkillsRepository employeeSkillsRepository;
    private ORMEmployeeRepository ormEmployeeRepository;

    @Autowired
    //private SkillRepository skillRepository;
    private ORMSkillRepository ormSkillRepository;

    @Autowired
    private AddSkillRequestValidator validator;

    //to-do: adjust response type
    public AddSkillResponse execute(AddSkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddSkillResponse(errors);
        }
        Employee employee = ormEmployeeRepository.getEmployeeById(request.getEmployeeId());
        Skill skillToAdd = new Skill(request.getSkillName());
        boolean added = false;
        if (!containsSkillToAdd(skillToAdd)) {
            added = ormSkillRepository.saveSkill(skillToAdd);
        }
        Long skillId = ormSkillRepository.getSkillIdByName(skillToAdd);
        skillToAdd.setSkillId(skillId);
        ormEmployeeRepository.saveEmployeeSkill(employee, skillToAdd);
        return new AddSkillResponse(added);
    }

    private boolean containsSkillToAdd(Skill skill) {
        return ormSkillRepository.getAllExistingSkills()
                .stream()
                .anyMatch(s -> s.getSkillName().equals(skill.getSkillName()));
    }
}