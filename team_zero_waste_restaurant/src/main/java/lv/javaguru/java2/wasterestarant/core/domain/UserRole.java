package lv.javaguru.java2.wasterestarant.core.domain;

public enum UserRole  {
    ADMIN("Admin"),
    CLIENT("Client");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
