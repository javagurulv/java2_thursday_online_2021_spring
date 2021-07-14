package lv.javaguru.java2.hrsystem.core.requests;

public class SearchEmployeesBySkillRequest {
    private String skillName;

    public SearchEmployeesBySkillRequest() {
    }

    public SearchEmployeesBySkillRequest(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}