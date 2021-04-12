package lv.javaguru.java2.realestate.requests;

public class CreateAccountRequest {

    private final String username;
    private final String password;

    public CreateAccountRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
