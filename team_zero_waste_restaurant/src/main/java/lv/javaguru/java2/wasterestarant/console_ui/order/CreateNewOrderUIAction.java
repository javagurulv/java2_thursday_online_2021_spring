package lv.javaguru.java2.wasterestarant.console_ui.order;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

@DIComponent
public class CreateNewOrderUIAction implements UIAction {
    @DIDependency
    private CreateNewOrderService createNewOrderService;

    @Override
    public void execute() {
        //TODO
    }
}


