package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetAllEmployeeSkillsResponse extends CoreResponse{
    private List<EmployeeSkill> employeeSkills;
    private Map<Employee, Set<Skill>> employeeSetMap;

    public GetAllEmployeeSkillsResponse(List<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public GetAllEmployeeSkillsResponse(Map<Employee, Set<Skill>> employeeSetMap) {
        this.employeeSetMap = employeeSetMap;
    }

    public List<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public boolean hasEmployeeSkills() {
        return !employeeSkills.isEmpty();
    }

    public Map<Employee, Set<Skill>> getEmployeeSetMap() {
        return employeeSetMap;
    }
}