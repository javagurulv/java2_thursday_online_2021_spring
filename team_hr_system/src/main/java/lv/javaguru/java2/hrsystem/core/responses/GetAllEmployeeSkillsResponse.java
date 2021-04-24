package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.EmployeeSkill;

import java.util.List;

public class GetAllEmployeeSkillsResponse extends CoreResponse{
    private List<EmployeeSkill> employeeSkills;

    public GetAllEmployeeSkillsResponse(List<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public List<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public boolean hasEmployeeSkills() {
        return !employeeSkills.isEmpty();
    }
}