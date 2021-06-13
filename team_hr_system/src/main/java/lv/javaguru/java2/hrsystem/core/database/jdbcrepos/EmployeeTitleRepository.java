package lv.javaguru.java2.hrsystem.core.database.jdbcrepos;

import lv.javaguru.java2.hrsystem.core.database.mappers.EmployeeTitleRowMapper;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeTitleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean saveTitle(EmployeeTitle employeeTitle) {
        String sql = "INSERT INTO employee_titles (title, title_description) VALUES (?, ?)";
        Object[] args = new Object[]{employeeTitle.getName(), employeeTitle.getDescription()};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public List<EmployeeTitle> getAllUniqueTitles() {
        String sql = "SELECT * FROM employee_titles";
        return jdbcTemplate.query(sql, new EmployeeTitleRowMapper());
    }

}