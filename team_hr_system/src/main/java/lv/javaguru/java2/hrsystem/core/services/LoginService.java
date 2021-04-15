package lv.javaguru.java2.hrsystem.core.services;


import lv.javaguru.java2.hrsystem.core.database.Database;

public class LoginService {

    public Database database;

    public LoginService(Database database) {

        this.database = database;

    }

    public Boolean execute (String email, String password){

        return database.loginAdm(email, password);

    }
}
