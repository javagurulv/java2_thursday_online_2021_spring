package lv.javaguru.java2.wasterestarant.core.requests.user;

import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

public class ChangeUserRoleRequest {
    private UserRole userRole;
    private String email;

    public ChangeUserRoleRequest() {
    }

    public ChangeUserRoleRequest(UserRole userRole, String email) {
        this.userRole = userRole;
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
