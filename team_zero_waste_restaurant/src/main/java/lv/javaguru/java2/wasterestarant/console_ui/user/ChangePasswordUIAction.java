package lv.javaguru.java2.wasterestarant.console_ui.user;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordUIAction implements UIAction {
    @Autowired
    private ChangePasswordService changePasswordService;

    @Override
    public void execute() {

    }
}
