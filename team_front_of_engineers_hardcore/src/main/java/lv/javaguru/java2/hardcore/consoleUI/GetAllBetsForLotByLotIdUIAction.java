package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.core.requests.bet.GetAllBetsForLotByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetAllBetsForLotByLotIdResponse;
import lv.javaguru.java2.hardcore.core.services.bet.GetAllBetsByLotIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class GetAllBetsForLotByLotIdUIAction implements UIAction{

    @Autowired
    private GetAllBetsByLotIdService getAllBetsByLotIdService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter lot id:");
        Long lotId = scanner.nextLong();
        System.out.println("Bet list for lot with id: " + lotId +" start" );
        GetAllBetsForLotByLotIdRequest request = new GetAllBetsForLotByLotIdRequest(lotId);
        GetAllBetsForLotByLotIdResponse response = getAllBetsByLotIdService.execute(request);
        response.getGetAllBetsByLotId().forEach(System.out::println);
        System.out.println("Bet list for lot with id: " + lotId +" end" );

    }
}
