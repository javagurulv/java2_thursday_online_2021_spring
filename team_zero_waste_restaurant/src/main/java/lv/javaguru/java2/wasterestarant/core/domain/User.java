package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_list")
public class User {
    private Long userId;
    private UserRole role;
    private String name;
    private String surname;
    private String email;
    private String password;

    public User() {
    }

    public User(Long userId, String name, String surname, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(Long clientID, UserRole role, String name, String surname, String email, String password) {
        this.userId = clientID;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && name.equals(user.name) && Objects.equals(surname, user.surname) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, name, surname, email);
    }
}
