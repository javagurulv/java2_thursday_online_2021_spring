package lv.javaguru.java2.hrsystem.core.database.jdbcrepos;

import lv.javaguru.java2.hrsystem.core.database.mappers.SkillRowMapper;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Skill> getAllExistingSkills() {
        return jdbcTemplate.query("SELECT * FROM skills", new SkillRowMapper());
    }

    public boolean addSkillToSkills(Skill skill) {
        String sql = "INSERT INTO skills (skill_name) VALUES (?)";
        Object[] args = new Object[]{skill.getSkillName()};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public Long getSkillIdByName(String skillName) {
        String sql = "SELECT id FROM skills WHERE skill_name = ?";
        Object[] args = new Object[]{skillName};
        return jdbcTemplate.queryForObject(sql, Long.class, args);
    }
}