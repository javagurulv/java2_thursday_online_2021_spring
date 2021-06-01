package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (first_name, last_name, age, employee_title) VALUES (?, ?, ?, ?)",
                employee.getName(), employee.getLastName(), employee.getAge(), employee.getTitle());
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