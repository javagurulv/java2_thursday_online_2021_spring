package lv.javaguru.java2.hrsystem.core.responses;

public class LoginResponse extends CoreResponse{

    private boolean login;

    public LoginResponse(boolean login) {
        this.login = login;
    }

    public boolean getLogin(){
        return login;
    }
}
