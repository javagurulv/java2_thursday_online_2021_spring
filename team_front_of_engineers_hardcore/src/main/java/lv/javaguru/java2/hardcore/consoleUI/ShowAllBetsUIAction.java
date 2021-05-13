package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.core.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.core.response.bet.ShowAllBetsResponse;
import lv.javaguru.java2.hardcore.core.services.bet.ShowAllBetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllBetsUIAction implements UIAction {
    @Autowired
    private ShowAllBetsService showAllBetsService;


    @Override
    public void execute() {
        System.out.println("Bet list: ");
        ShowAllBetsRequest request = new ShowAllBetsRequest();
        ShowAllBetsResponse response = showAllBetsService.execute(request);
        response.getShowAllBets().forEach(System.out::println);
        System.out.println("\nBet list end");
    }
}
