package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.LoginService;

public class LoginUIAction implements UIAction{
    private LoginService loginService;

    public LoginUIAction(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void execute() {

    }
}
