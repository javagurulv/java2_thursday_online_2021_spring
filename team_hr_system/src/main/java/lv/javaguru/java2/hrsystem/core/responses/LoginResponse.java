package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class LoginResponse extends CoreResponse{

    private boolean login;

    public LoginResponse(List<CoreError> errors) {
        super(errors);
    }

    public LoginResponse(boolean login) {
        this.login = login;
    }

    public boolean getLogin(){
        return login;
    }
}
