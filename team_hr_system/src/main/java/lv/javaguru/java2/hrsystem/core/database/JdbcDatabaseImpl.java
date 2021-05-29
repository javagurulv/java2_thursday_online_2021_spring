package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
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
                "INSERT INTO users (user_role, first_name, last_name, email, password) "
                        + "VALUES (?, ?, ?, ?, ?)",
                user.getUserRole(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()
        );
    }

    @Override
    public Optional<User> authorizeUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE user_role = ? AND email = ? AND password = ?";
        Object[] args = new Object[]{"ADMIN", email, password};
        return jdbcTemplate.query(sql, args, new UserRowMapper()).stream().findFirst();
    }

    @Override
    public void saveEmployee(Employee employee) {
        jdbcTemplate.update(
                "INSERT INTO employees (first_name, last_name, age, employee_title) "
                        + "VALUES (?, ?, ?, ?)",
                employee.getName(), employee.getLastName(), employee.getAge(), employee.getTitle()
        );
    }

    @Override
    public boolean deleteEmployee(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        String sql = "SELECT * FROM employees WHERE employee_title = ?";
        Object[] args = new Object[]{title};
        return jdbcTemplate.query(sql, args, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        String sql = "SELECT * FROM employees WHERE first_name = ?";
        Object[] args = new Object[]{name};
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
        return EnumSet.allOf(EmployeeTitle.class);
    }

    @Override
    public List<Employee> getEmployeesBySkill(Skill skill) {
        String sql = "SELECT empl_id AS id, first_name, last_name, age, employee_title, skill_id FROM employee_skills \n" +
                "JOIN employees ON employees.id = empl_id \n" +
                "WHERE skill_id = ?";
        Object[] args = new Object[]{skill.getSkillId()};
        return jdbcTemplate.query(sql, args, new EmployeeRowMapper());
    }

    @Override
    public boolean addSkill(Employee employee, Skill skill) {
        String sql =
                "INSERT INTO employee_skills (empl_id, skill_id) "
                        + "VALUES (?, ?)";
        Object[] args = new Object[]{employee.getId(), skill.getSkillId()};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<EmployeeSkill> getAllSkills() {
        String sql = "SELECT * FROM employee_skills\n" +
                "JOIN employees ON employees.id = empl_id\n" +
                "JOIN skills on skills.id = skill_id";
        return jdbcTemplate.query(sql, new EmployeeSkillRowMapper());
    }

    @Override
    public List<Skill> getAllExistingSkills() {
        String sql = "SELECT * FROM skills";
        return jdbcTemplate.query(sql, new SkillRowMapper());
    }
}
