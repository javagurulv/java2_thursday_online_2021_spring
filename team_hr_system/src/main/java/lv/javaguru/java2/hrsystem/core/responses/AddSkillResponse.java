package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class AddSkillResponse extends CoreResponse{
    private boolean employeeSkillAdded;

    public AddSkillResponse(boolean employeeSkillAdded) {
        this.employeeSkillAdded = employeeSkillAdded;
    }

    public AddSkillResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isEmployeeSkillAdded() {
        return employeeSkillAdded;
    }
}