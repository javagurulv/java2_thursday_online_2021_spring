package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class CreateUserRequest {

    private final String username;
    private final String password;

    public CreateUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
