package lv.javaguru.java2.wasterestarant.core.domain;

public enum UserRole  {
    ADMIN("ADMIN"),
    CLIENT("CLIENT");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
