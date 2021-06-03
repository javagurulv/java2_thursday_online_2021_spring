package lv.javaguru.java2.hardcore.consoleUI;


import org.springframework.stereotype.Component;

@Component
public class UserSession {

    private Long userID;
    private boolean authorized = false;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
