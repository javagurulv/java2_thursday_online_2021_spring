package lv.javaguru.java2.hrsystem.core.database.mappers;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSkillRowMapper implements RowMapper<EmployeeSkill> {

    @Override
    public EmployeeSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeSkill employeeSkill = new EmployeeSkill();
        Employee employee = new Employee();
        employee.setId(rs.getLong("empl_id"));
         employee.setName(rs.getString("first_name"));
         employee.setLastName(rs.getString("last_name"));

        Skill skill = new Skill();
        skill.setSkillId(rs.getLong("skill_id"));
        skill.setSkillName(rs.getString("skill_name"));

        employeeSkill.setId(rs.getLong("id"));
        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);

        return employeeSkill;
    }
}