package lv.javaguru.java2.hrsystem.core.database.mappers;

import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillRowMapper implements RowMapper<Skill> {

    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill skill = new Skill();
        skill.setSkillId(rs.getLong("id"));
        skill.setSkillName(rs.getString("skill_name"));
        return skill;
    }
}