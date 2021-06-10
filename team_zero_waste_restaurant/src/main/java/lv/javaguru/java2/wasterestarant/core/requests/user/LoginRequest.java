package lv.javaguru.java2.wasterestarant.core.requests.user;

public class LoginRequest {
    private String name;
    private String password;

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

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isPasswordProvided() {
        return this.name != null && !this.name.isEmpty();
    }
}
