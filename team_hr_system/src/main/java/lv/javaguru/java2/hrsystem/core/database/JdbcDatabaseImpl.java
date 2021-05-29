package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
class JdbcDatabaseImpl implements Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void registerUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (user_role, first_name, last_name, email, password)"
                + "VALUES (?, ?, ?, ?, ?)",
                user.getUserRole(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()
        );
    }

    @Override
    public Optional<User> authorizeUser(String email, String password) {
        return Optional.empty();
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getTitle() != null) {
            jdbcTemplate.update(
                    "INSERT INTO employees (first_name, last_name, age, employee_title)"
                            + "VALUES (?, ?, ?, ?)",
                    employee.getName(), employee.getLastName(), employee.getAge(), employee.getTitle()
            );
        } else {
            jdbcTemplate.update(
                    "INSERT INTO employees (first_name, last_name, age, employee_title)"
                            + "VALUES (?, ?, ?)",
                    employee.getName(), employee.getLastName(), employee.getAge()
            );
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        String sql = "SELECT * FROM employees WHERE employee_title = ?";
        Object[] args = new Object[] {title};
        return jdbcTemplate.query(sql, args, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        String sql = "SELECT * FROM employees WHERE first_name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByTitleAndName(EmployeeTitle title, String name) {
        String sql = "SELECT * FROM employees WHERE title = ? AND first_name = ?";
        Object[] args = new Object[]{title, name};
        return jdbcTemplate.query(sql, args, new EmployeeRowMapper());
    }

    @Override
    public Set<EmployeeTitle> getAllTitles() {
        return null;
    }

    @Override
    public List<Employee> getEmployeesBySkill(Skill skill) {
        return null;
    }

    @Override
    public boolean addSkill(Employee employee, Skill skill) {
        return false;
    }

    @Override
    public List<EmployeeSkill> getAllSkills() {
        return null;
    }

    @Override
    public List<Skill> getAllExistingSkills() {
        return null;
    }
}
