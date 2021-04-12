package lv.javaguru.java2.realestate.core.requests;

public class DeleteUserRequest {
    private final String username;
    private final String password;

    public DeleteUserRequest(String username, String password) {
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
