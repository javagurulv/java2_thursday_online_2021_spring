package lv.javaguru.java2.wasterestarant.console_ui.user;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.services.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUIAction implements UIAction {
    @Autowired
    private LoginService loginService;

    @Override
    public void execute() {

    }
}
