package lv.javaguru.java2.hrsystem.matchers;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.mockito.ArgumentMatcher;

public class EmployeeMatcher implements ArgumentMatcher<Employee> {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private EmployeeTitle title;

    public EmployeeMatcher(String name, String lastName, int age, EmployeeTitle title) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.title = title;
    }

    public EmployeeMatcher(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public EmployeeMatcher(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public EmployeeMatcher(Long id, String name, String lastName, int age, EmployeeTitle title) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.title = title;
    }

    @Override
    public boolean matches(Employee employee) {
        return employee.getName().equals(name) &&
                employee.getLastName().equals(lastName) &&
                employee.getAge() == age ;//&&
        // employee.getTitle().equals(title);
    }
}