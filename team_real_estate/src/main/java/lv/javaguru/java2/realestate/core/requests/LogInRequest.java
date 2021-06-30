package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class LogInRequest {
    private final String username;
    private final String password;

    public LogInRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
