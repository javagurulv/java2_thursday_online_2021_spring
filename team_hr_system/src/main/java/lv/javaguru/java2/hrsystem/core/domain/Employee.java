package lv.javaguru.java2.hrsystem.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

   // @Column(name = "employee_title")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_title", referencedColumnName = "title")
    private EmployeeTitle title;

    public Employee(String name, String lastName, int age, EmployeeTitle title) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.title = title;
    }

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Employee(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Employee(Long id, String name, String lastName, int age, EmployeeTitle title) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.title = title;
    }

    public Employee(Long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Employee(Long employeeId) {
        this.id = employeeId;
    }

    public Employee() {

    }

    public EmployeeTitle getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "Employee - " +
                "id = " + id +
                ", Name = '" + name + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", age = " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(title, employee.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age, title);
    }
}