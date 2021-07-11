package lv.javaguru.java2.hrsystem.core.requests;

import lv.javaguru.java2.hrsystem.core.domain.UserRole;

public class UpdateUserRoleRequest {
    private Long id;
    private UserRole userRole;

    public UpdateUserRoleRequest() {
    }

    public UpdateUserRoleRequest(Long id, UserRole userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
