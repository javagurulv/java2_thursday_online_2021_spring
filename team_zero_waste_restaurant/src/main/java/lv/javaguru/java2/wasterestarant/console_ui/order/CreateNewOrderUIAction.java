package lv.javaguru.java2.wasterestarant.console_ui.order;

import lv.javaguru.java2.wasterestarant.console_ui.UIAction;
import lv.javaguru.java2.wasterestarant.core.services.order.CreateNewOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNewOrderUIAction implements UIAction {
    @Autowired
    private CreateNewOrderService createNewOrderService;

    @Override
    public void execute() {
        //TODO
    }
}


