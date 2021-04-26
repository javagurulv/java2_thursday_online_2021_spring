package lv.javaguru.java2.hardcore.consoleUI.bet;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.services.bet.AddBetService;

import java.math.BigDecimal;
import java.util.Scanner;

public class AddBetUIAction implements UIAction {

    private AddBetService addBetService;

    public AddBetUIAction(AddBetService addBetService) {
        this.addBetService = addBetService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item id,from lot list: ");
        Long betId = scanner.nextLong();
        System.out.println("Enter your bet: ");
        BigDecimal betPrice = scanner.nextBigDecimal();
        AddBetRequest request = new AddBetRequest(betId,betPrice);
        AddBetResponse response = addBetService.execute(request);
        if(response.hasErrors()){
            response.getErrors().forEach(coreError -> System.out.println("Error: "+coreError.getField()+" "+coreError.getMessage() ));
        }else {
            System.out.println("Your bet was: "+response.getNewBet());
            System.out.println("Your bet was added to list.");
        }
    }
}
