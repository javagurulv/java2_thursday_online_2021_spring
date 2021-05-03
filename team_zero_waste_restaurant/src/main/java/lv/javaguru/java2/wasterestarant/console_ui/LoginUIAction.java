package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.LoginService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

@DIComponent
public class LoginUIAction implements UIAction{
    @DIDependency
    private LoginService loginService;

    @Override
    public void execute() {

    }
}
