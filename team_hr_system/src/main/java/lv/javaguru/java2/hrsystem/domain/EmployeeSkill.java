package lv.javaguru.java2.hrsystem.domain;

import java.util.Objects;

public class EmployeeSkill {
    private Employee employee;
    private Skill skill;

    public EmployeeSkill(Employee employee, Skill skill) {
        this.employee = employee;
        this.skill = skill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Skill getSkill() {
        return skill;
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