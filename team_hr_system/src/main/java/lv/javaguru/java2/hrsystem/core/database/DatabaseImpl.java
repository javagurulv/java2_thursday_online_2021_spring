package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.domain.Admin;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

public class DatabaseImpl implements Database{

    private Long nextIdEmployee = 1L;
    private Long nextIdAdmin = 1L;
    private List <Employee> employeeList = new ArrayList<>();
    private List<EmployeeTitle> employeeTitles = new ArrayList<>();
    private static List<Admin> adminList = new ArrayList<>();
    private static final String filename = "admin.txt";

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
    public List<EmployeeTitle> getAllTitles() {
        return employeeTitles;
    }
}