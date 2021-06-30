package lv.javaguru.java2.wasterestarant.core.requests.user;

public class ChangePasswordRequest {
    private String email;

    public ChangePasswordRequest() {
    }

    public ChangePasswordRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
