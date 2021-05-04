package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.RegistrationService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

@DIComponent
public class RegistrationUIAction implements UIAction {
    @DIDependency
    private RegistrationService registrationService;

    @Override
    public void execute() {

    }
}
