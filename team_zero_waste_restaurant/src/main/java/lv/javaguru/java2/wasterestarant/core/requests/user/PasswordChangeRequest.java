package lv.javaguru.java2.wasterestarant.core.requests.user;

public class PasswordChangeRequest {
    private String email;

    public PasswordChangeRequest() {
    }

    public PasswordChangeRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
