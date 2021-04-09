package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.services.GetAllLotsService;

public class GetAllLotsUIAction implements UIAction {

    private GetAllLotsService getAllLotsService;

    public GetAllLotsUIAction(GetAllLotsService getAllLotsService) {
        this.getAllLotsService = getAllLotsService;
    }

    @Override
    public void execute() {
        System.out.println("lv.javaguru.java2.hardcore.DataModels.Lot list: ");
        getAllLotsService.execute().forEach(System.out::println);
        System.out.println("\nlv.javaguru.java2.hardcore.DataModels.Lot list end.");
    }
}
