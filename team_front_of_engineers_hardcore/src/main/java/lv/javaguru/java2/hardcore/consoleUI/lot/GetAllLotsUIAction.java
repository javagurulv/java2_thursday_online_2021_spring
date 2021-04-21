package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.response.lot.ShowAllLotsResponse;
import lv.javaguru.java2.hardcore.services.lot.GetAllLotsService;

public class GetAllLotsUIAction implements UIAction {

    private GetAllLotsService getAllLotsService;

    public GetAllLotsUIAction(GetAllLotsService getAllLotsService) {
        this.getAllLotsService = getAllLotsService;
    }

    @Override
    public void execute() {
        System.out.println("Lot list: ");
        GetAllLotsRequest request = new GetAllLotsRequest();
        ShowAllLotsResponse response = getAllLotsService.execute(request);
        response.getGetAllLots().forEach(System.out::println);
        System.out.println("\nLot list end");
    }
}
