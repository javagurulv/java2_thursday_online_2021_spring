package lv.javaguru.java2.hrsystem.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee_titles")
public class EmployeeTitle implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "employee_titles")
    private Long id;

    @Column(name = "title", nullable = false)
    private String name;

    @Column(name = "title_description")
    private String description;

    //@OneToMany(mappedBy = "title")
    //private Set<Employee> employees = new HashSet<>();

    public EmployeeTitle() {
    }

    public EmployeeTitle(Long id) {
        this.id = id;
    }

    public EmployeeTitle(String name) {
        this.name = name;
    }

    public EmployeeTitle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public EmployeeTitle(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTitle that = (EmployeeTitle) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return name;
    }
}