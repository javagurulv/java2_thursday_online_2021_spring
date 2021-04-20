package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.RegistrationService;

public class RegistrationUIAction implements UIAction{
    private RegistrationService registrationService;

    public RegistrationUIAction(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void execute() {

    }
}
