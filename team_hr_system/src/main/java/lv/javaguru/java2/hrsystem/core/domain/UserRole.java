package lv.javaguru.java2.hrsystem.core.domain;

import java.io.Serializable;

public enum UserRole implements Serializable {

    ADMIN("Admin"),
    HR_MANAGER("HR Manager");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
