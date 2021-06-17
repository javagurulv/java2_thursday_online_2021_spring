package lv.javaguru.java2.hardcore.consoleUI;



import lv.javaguru.java2.hardcore.core.requests.bet.GetHighestBetByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetHighestBetByIdResponse;
import lv.javaguru.java2.hardcore.core.services.bet.GetHighestBetByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GetHighestBetForLotByLotIdUIAction implements UIAction{

    @Autowired
    private GetHighestBetByIdService getHighestBetByIdService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter lot id: ");
        Long lotId = scanner.nextLong();
        GetHighestBetByLotIdRequest request = new GetHighestBetByLotIdRequest(lotId);
        GetHighestBetByIdResponse response = getHighestBetByIdService.execute(request);
        System.out.println("Highest bet for lot with id:" + request.getId()+" is: " + response.getBet());

    }
}
