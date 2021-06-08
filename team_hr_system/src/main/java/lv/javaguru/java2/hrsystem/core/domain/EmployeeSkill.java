package lv.javaguru.java2.hrsystem.core.domain;

import java.util.Objects;

public class EmployeeSkill {
    private Long id;
    private Employee employee;
    private Skill skill;

    public EmployeeSkill(Employee employee, Skill skill) {
        this.employee = employee;
        this.skill = skill;
    }

    public EmployeeSkill() {

    }

    public EmployeeSkill(Long id, Employee employee, Skill skill) {
        this.id = id;
        this.employee = employee;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkill that = (EmployeeSkill) o;
        return Objects.equals(employee, that.employee) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, skill);
    }

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "employee=" + employee +
                ", skill=" + skill +
                '}';
    }
}