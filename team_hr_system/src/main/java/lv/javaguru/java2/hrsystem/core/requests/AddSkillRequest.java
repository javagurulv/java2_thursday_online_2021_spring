package lv.javaguru.java2.hrsystem.core.requests;

public class AddSkillRequest {
    private Long employeeId;
    private String skillName;

    public AddSkillRequest() {
    }

    public AddSkillRequest(Long employeeId, String skillName) {
        this.employeeId = employeeId;
        this.skillName = skillName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}