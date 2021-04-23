package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.domain.*;

import java.util.List;
import java.util.Set;

public interface Database {

    void registrationAdm (Admin admin);

    boolean loginAdm(String email, String password);

    void saveEmployee(Employee employee);

    boolean deleteEmployee(Long id);

    List <Employee> getAllEmployees();

    List<Employee> getEmployeesByTitle(EmployeeTitle title);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByTitleAdnName(EmployeeTitle title, String name);

    Set<EmployeeTitle> getAllTitles();

    List<Employee> getEmployeesBySkill(Skill skill);

    boolean addSkill(Employee employee, Skill skill);

}