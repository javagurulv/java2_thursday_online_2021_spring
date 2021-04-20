package lv.javaguru.java2.hardcore.requests.user;

public class LoginRequest {
    private final String name;
    private final String password;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
