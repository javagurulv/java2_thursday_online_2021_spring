package lv.javaguru.java2.wasterestarant.core.requests.user;

import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

public class ChangeUserRoleRequest {
    private UserRole userRole;
    private String email;
    private String password;

    public ChangeUserRoleRequest() {
    }

    public ChangeUserRoleRequest(UserRole userRole, String email, String password) {
        this.userRole = userRole;
        this.email = email;
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
