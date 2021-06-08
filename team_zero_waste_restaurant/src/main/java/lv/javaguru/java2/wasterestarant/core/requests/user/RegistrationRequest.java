package lv.javaguru.java2.wasterestarant.core.requests.user;

import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

import static lv.javaguru.java2.wasterestarant.core.domain.UserRole.CLIENT;

public class RegistrationRequest {
    private UserRole userRole;
    private String name;
    private String surname;
    private String email;
    private String password;

    public RegistrationRequest(UserRole userRole, String name, String surname, String email, String password) {
        this.userRole = userRole;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public UserRole getUserRole() {
        return CLIENT;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
