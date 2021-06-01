package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeSkillsRepository;
import lv.javaguru.java2.hrsystem.core.database.SkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSkillService {

    @Autowired
    private EmployeeSkillsRepository employeeSkillsRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private AddSkillRequestValidator validator;

    public AddSkillResponse execute(AddSkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddSkillResponse(errors);
        }
        Skill skillToAdd = new Skill(request.getSkillName());
        if (!containsSkill(skillToAdd)) {
            skillRepository.addSkillToSkills(skillToAdd);
        }
        Long skillId = skillRepository.getSkillIdByName(skillToAdd.getSkillName());
        skillToAdd.setSkillId(skillId);
        boolean added;
        EmployeeSkill employeeSkillToAdd = new EmployeeSkill(new Employee(request.getEmployeeId()), skillToAdd);
        if (!containsEmplSkill(employeeSkillToAdd)) {
            added = employeeSkillsRepository.addEmplSkill(employeeSkillToAdd);
        }
        else {
            added = false;
        }
        return new AddSkillResponse(added);
    }

    private boolean containsEmplSkill(EmployeeSkill employeeSkill) {
        return employeeSkillsRepository.getAllEmplSkills()
                .stream()
                .anyMatch(eSkill -> eSkill.getEmployee().getId().equals(employeeSkill.getEmployee().getId()) &&
                        eSkill.getSkill().getSkillId().equals(employeeSkill.getSkill().getSkillId()));
    }

    private boolean containsSkill(Skill skill) {
        return skillRepository.getAllExistingSkills()
                .stream()
                .anyMatch(sk -> sk.getSkillName().equals(skill.getSkillName()));
    }
}