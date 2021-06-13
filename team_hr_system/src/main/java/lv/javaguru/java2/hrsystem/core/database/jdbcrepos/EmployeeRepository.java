package lv.javaguru.java2.hrsystem.core.database.jdbcrepos;

import lv.javaguru.java2.hrsystem.core.database.mappers.EmployeeRowMapper;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (first_name, last_name, age, employee_title) VALUES (?, ?, ?, ?)",
                employee.getName(), employee.getLastName(), employee.getAge(), employee.getTitle().getName());
    }

    public BigInteger saveEmployeeAndReturnID(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO employees (first_name, last_name, age) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            return ps;
        }, keyHolder);

        return (BigInteger) keyHolder.getKey();
    }

    public BigInteger saveEmployeeWithTitleAndReturnID(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO employees (first_name, last_name, age, employee_title) VALUES (?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getTitle().getName());
            return ps;
        }, keyHolder);

        return (BigInteger) keyHolder.getKey();
    }

    public boolean deleteEmployee(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeRowMapper());
    }

    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        String sql = "SELECT * FROM employees WHERE employee_title = ?";
        Object[] args = new Object[]{title};
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), args);
    }

    public List<Employee> getEmployeesByName(String name) {
        String sql = "SELECT * FROM employees WHERE first_name = ?";
        Object[] args = new Object[]{name};
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), args);
    }

    public List<Employee> getEmployeesByTitleAndName(EmployeeTitle title, String name) {
        String sql = "SELECT * FROM employees WHERE employee_title = ? AND first_name = ?";
        Object[] args = new Object[]{title, name};
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), args);
    }
}