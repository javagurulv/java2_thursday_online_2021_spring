package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.services.bet.AddBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class AddBetUIAction implements UIAction {

    @Autowired
    private AddBetService addBetService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item id,from lot list: ");
        Long betId = scanner.nextLong();
        System.out.println("Enter your bet: ");
        BigDecimal betPrice = scanner.nextBigDecimal();
        AddBetRequest request = new AddBetRequest(betId, betPrice);
        AddBetResponse response = addBetService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Your bet was: " + response.getNewBet());
            System.out.println("Your bet was added to list.");
        }
    }
}
