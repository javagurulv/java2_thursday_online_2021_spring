package lv.javaguru.java2.hrsystem.core.database.mappers;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setAge(rs.getInt("age"));
        EmployeeTitle employeeTitle = new EmployeeTitle();
        employeeTitle.setName(rs.getString("employee_title"));
        employee.setTitle(employeeTitle);
        return employee;
    }
}