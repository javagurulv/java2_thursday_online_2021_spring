package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Skill;

import java.util.List;

public class GetAllExistingSkillsResponse extends CoreResponse{
    private List<Skill> skills;

    public GetAllExistingSkillsResponse(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public boolean hasSkills() {
        return !skills.isEmpty();
    }
}