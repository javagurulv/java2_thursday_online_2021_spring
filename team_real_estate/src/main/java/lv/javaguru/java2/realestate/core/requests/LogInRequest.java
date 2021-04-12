package lv.javaguru.java2.realestate.core.requests;

public class LogInRequest {
    private final String username;
    private final String password;

    public LogInRequest(String username, String password) {
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
