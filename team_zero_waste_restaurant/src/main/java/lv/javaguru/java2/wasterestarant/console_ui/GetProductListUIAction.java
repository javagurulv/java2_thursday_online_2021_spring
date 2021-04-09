package lv.javaguru.java2.wasterestarant.console_ui;

import lv.javaguru.java2.wasterestarant.core.services.GetProductListService;

public class GetProductListUIAction implements UIAction{
    private GetProductListService getProductListService;

    public GetProductListUIAction(GetProductListService getProductListService) {
        this.getProductListService = getProductListService;
    }

    @Override
    public void execute() {
        getProductListService.execute();
    }
}
