package lv.javaguru.java2.hrsystem.core.database.mappers;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeTitleRowMapper implements RowMapper<EmployeeTitle> {

    @Override
    public EmployeeTitle mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeTitle employeeTitle = new EmployeeTitle();
        employeeTitle.setId(rs.getLong("id"));
        employeeTitle.setName(rs.getString("title"));
        employeeTitle.setDescription(rs.getString("title_description"));
        return employeeTitle;
    }
}
