package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.domain.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DatabaseImpl implements Database {

    private Long nextIdEmployee = 1L;
    private Long nextIdAdmin = 1L;
    private List<Employee> employeeList = new ArrayList<>();
    private EnumSet<EmployeeTitle> employeeTitles = EnumSet.allOf(EmployeeTitle.class);
    private static List<Admin> adminList = new ArrayList<>();
    private static final String filename = "admin.txt";
    private List<EmployeeSkill> employeeSkills = new ArrayList<>();

    static {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            adminList = (List<Admin>) objectInputStream.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrationAdm(Admin admin) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            admin.setId(nextIdAdmin);
            nextIdAdmin++;
            adminList.add(admin);
            objectOutputStream.writeObject(admin);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean loginAdm(String email, String password) {
        return adminList.stream().anyMatch(admin -> admin.getEmail().equals(email)) &&
                adminList.stream().anyMatch(admin -> admin.getPassword().equals(password));
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setId(nextIdEmployee);
        nextIdEmployee++;
        employeeList.add(employee);
        //  employeeTitles.add(employee.getTitle());
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(e -> e.getId().equals(id));
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