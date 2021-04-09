package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.AddProductService;

public class AddProductUIAction implements UIAction{
    private AddProductService addProductService;

    public AddProductUIAction(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        addProductService.execute();
    }
}
