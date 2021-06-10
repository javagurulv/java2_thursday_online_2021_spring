package lv.javaguru.java2.hrsystem.core.database.jdbcrepos;

import lv.javaguru.java2.hrsystem.core.database.mappers.EmployeeSkillRowMapper;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSkillsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmployeeSkill> getEmplSkillsBySkillName(Skill skill) {
        String sql = "SELECT empl_id, first_name, last_name, skill_id, skill_name FROM employee_skills INNER JOIN skills ON employee_skills.skill_id=skills.id INNER JOIN employees ON employee_skills.empl_id = employees.id WHERE skill_name = ?";
        Object[] args = new Object[]{skill.getSkillName()};
        return jdbcTemplate.query(sql, new EmployeeSkillRowMapper(), args);
    }

    public boolean addEmplSkill(EmployeeSkill employeeSkill) {
        String sql = "INSERT INTO employee_skills (empl_id, skill_id) VALUES (?, ?)";
        Object[] args = new Object[]{employeeSkill.getEmployee().getId(), employeeSkill.getSkill().getSkillId()};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public List<EmployeeSkill> getAllEmplSkills() {
        return jdbcTemplate.query("SELECT employee_skills.id, empl_id, first_name, last_name, skill_id, skill_name FROM employee_skills INNER JOIN skills ON employee_skills.skill_id=skills.id INNER JOIN employees ON employee_skills.empl_id = employees.id",
                new EmployeeSkillRowMapper());
    }
}