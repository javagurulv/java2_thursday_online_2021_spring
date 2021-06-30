package lv.javaguru.java2.hrsystem.core.requests;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;

public class RegisterUserRequest {

    private UserRole userRole;
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(UserRole userRole, String firstName, String secondName, String email, String password) {
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

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
