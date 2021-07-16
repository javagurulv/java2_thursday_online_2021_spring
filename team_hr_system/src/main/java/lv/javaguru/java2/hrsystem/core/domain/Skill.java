package lv.javaguru.java2.hrsystem.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "skills")
    private Long skillId;

    @Column(name = "skill_name", nullable = false, unique = true)
    private String skillName;

    //to-do: does not work without eager
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private Set<Employee> employees = new HashSet<>();

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Skill(Long skillId) {
        this.skillId = skillId;
    }

    public Skill(Long skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public Skill() {

    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @JsonIgnore
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(skillId, skill.skillId) && Objects.equals(skillName, skill.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, skillName);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}