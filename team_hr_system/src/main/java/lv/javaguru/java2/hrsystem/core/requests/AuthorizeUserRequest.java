package lv.javaguru.java2.hrsystem.core.requests;

public class AuthorizeUserRequest {

    private String email;
    private String password;

    public AuthorizeUserRequest() {
    }

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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
