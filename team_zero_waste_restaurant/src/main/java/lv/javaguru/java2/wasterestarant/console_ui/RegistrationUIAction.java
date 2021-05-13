package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUIAction implements UIAction {
    @Autowired
    private RegistrationService registrationService;

    @Override
    public void execute() {

    }
}
