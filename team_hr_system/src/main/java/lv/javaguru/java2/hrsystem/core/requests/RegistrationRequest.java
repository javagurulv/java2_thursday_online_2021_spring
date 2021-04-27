package lv.javaguru.java2.hrsystem.core.requests;

import lv.javaguru.java2.hrsystem.domain.UserRole;

public class RegistrationRequest {

    private UserRole userRole;
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public RegistrationRequest(UserRole userRole, String firstName, String secondName, String email, String password) {
        this.userRole = userRole;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
