package lv.javaguru.java2.wasterestarant.core.requests.user;

public class ChangeUserRoleRequest {
    private String email;
    private String password;

    public ChangeUserRoleRequest() {
    }

    public ChangeUserRoleRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
