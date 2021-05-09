package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUIAction implements UIAction{
    @Autowired
    private LoginService loginService;

    @Override
    public void execute() {

    }
}
