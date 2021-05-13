package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;

import lv.javaguru.java2.hardcore.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.response.lot.GetAllLotsResponse;
import lv.javaguru.java2.hardcore.services.lot.GetAllLotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllLotsUIAction implements UIAction {
    @Autowired
    private GetAllLotsService getAllLotsService;


    @Override
    public void execute() {
        System.out.println("Lot list: ");
        GetAllLotsRequest request = new GetAllLotsRequest();
        GetAllLotsResponse response = getAllLotsService.execute(request);
        response.getGetAllLots().forEach(System.out::println);
        System.out.println("\nLot list end");
    }
}
