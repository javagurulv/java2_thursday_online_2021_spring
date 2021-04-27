package lv.javaguru.java2.hrsystem.core.requests;

public class AuthorizationRequest {

    private String email;
    private String password;

    public AuthorizationRequest(String email, String password) {
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
