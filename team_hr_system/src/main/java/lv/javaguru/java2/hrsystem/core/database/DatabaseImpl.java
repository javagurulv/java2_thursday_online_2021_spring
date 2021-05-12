package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.*;

@Component
public class DatabaseImpl implements Database {

    private Long nextIdEmployee = 1L;
    private Long nextIdUser = userList.size() + 1L;
    private List<Employee> employeeList = new ArrayList<>();
    private EnumSet<EmployeeTitle> employeeTitles = EnumSet.allOf(EmployeeTitle.class);
    private static List<User> userList = new ArrayList<>();
    private static final String filename = "user.out";
    private List<EmployeeSkill> employeeSkills = new ArrayList<>();

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            userList = ((List<User>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registerUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            user.setId(nextIdUser);
            nextIdUser++;
            userList.add(user);
            oos.writeObject(userList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Optional<User> authorizeUser(String email, String password) {
        return userList.stream()
                .filter(admin -> admin.getEmail().equals(email) && admin.getPassword().equals(password))
                .findFirst();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setId(nextIdEmployee);
        nextIdEmployee++;
        employeeList.add(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByTitle(EmployeeTitle title) {
        return employeeList.stream()
                .filter(employee -> employee.getTitle() != null && employee.getTitle().equals(title))
                .collect(toList());
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeList.stream().filter(e -> e.getName().equalsIgnoreCase(name)).collect(toList());
    }

    @Override
    public List<Employee> getEmployeesByTitleAdnName(EmployeeTitle title, String name) {
        return employeeList.stream()
                .filter(e -> e.getTitle() != null && e.getTitle().equals(title) && e.getName().equalsIgnoreCase(name))
                .collect(toList());
    }

    @Override
    public Set<EmployeeTitle> getAllTitles() {
        return employeeTitles;
    }

    @Override
    public List<Employee> getEmployeesBySkill(Skill skill) {
        return employeeSkills.stream()
                .filter(e -> e.getSkill().equals(skill))
                .map(EmployeeSkill::getEmployee)
                .collect(toList());
    }

    @Override
    public boolean addSkill(Employee employee, Skill skill) {
        EmployeeSkill employeeSkill = new EmployeeSkill(employee, skill);
        if (!employeeSkills.contains(employeeSkill)) {
            employeeSkills.add(employeeSkill);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeSkill> getAllSkills() {
        return employeeSkills;
    }
}