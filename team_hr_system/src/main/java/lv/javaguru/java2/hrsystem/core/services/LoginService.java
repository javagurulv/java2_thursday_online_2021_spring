package lv.javaguru.java2.hrsystem.core.services;


import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.LoginRequest;
import lv.javaguru.java2.hrsystem.core.responses.LoginResponse;

public class LoginService {

    public Database database;

    public LoginService(Database database) {

        this.database = database;

    }

    public LoginResponse execute (LoginRequest loginRequest){

        boolean login = database.loginAdm(loginRequest.getEmail(), loginRequest.getPassword());

        return new LoginResponse(login);

    }
}
