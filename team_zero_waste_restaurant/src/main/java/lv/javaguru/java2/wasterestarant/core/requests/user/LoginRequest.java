package lv.javaguru.java2.wasterestarant.core.requests.user;

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isNameProvided() {
        return this.email != null && !this.email.isEmpty();
    }

    public boolean isPasswordProvided() {
        return this.password != null && !this.password.isEmpty();
    }
}
