package lv.javaguru.java2.hardcore.consoleUI;


import org.springframework.stereotype.Component;

@Component
public class UserSession {

    private String username;
    private boolean authorized = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
