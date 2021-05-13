package lv.javaguru.java2.hardcore.core.requests.user;

public class AddUserRequest {

    private String name;
    private String password;

    public AddUserRequest(String name, String password) {
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
