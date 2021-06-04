package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.*;

import java.util.*;

public interface Database {

    void registerUser(User user);

    Optional<User> authorizeUser(String email, String password);

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List<User> getAllUsers();

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesByTitle(EmployeeTitle title);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByTitleAndName(EmployeeTitle title, String name);

    //Set<EmployeeTitle> getAllTitles();

    List<Employee> getEmployeesBySkill(Skill skill);

    boolean addSkill(Employee employee, Skill skill);

    List<EmployeeSkill> getAllSkills();

    List<Skill> getAllExistingSkills();

}