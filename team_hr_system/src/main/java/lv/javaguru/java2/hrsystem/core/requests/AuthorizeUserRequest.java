package lv.javaguru.java2.hrsystem.core.requests;

public class AuthorizeUserRequest {

    private String email;
    private String password;

    public AuthorizeUserRequest(String email, String password) {
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
