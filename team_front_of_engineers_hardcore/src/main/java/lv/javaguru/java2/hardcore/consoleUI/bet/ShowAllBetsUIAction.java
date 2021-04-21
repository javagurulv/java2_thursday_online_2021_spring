package lv.javaguru.java2.hardcore.consoleUI.bet;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.response.bet.ShowAllBetsResponse;
import lv.javaguru.java2.hardcore.services.bet.ShowAllBetsService;

public class ShowAllBetsUIAction implements UIAction {

    private ShowAllBetsService showAllBetsService;

    public ShowAllBetsUIAction(ShowAllBetsService showAllBetsService) {
        this.showAllBetsService = showAllBetsService;
    }

    @Override
    public void execute() {
        System.out.println("Bet list: ");
        ShowAllBetsRequest request = new ShowAllBetsRequest();
        ShowAllBetsResponse response = showAllBetsService.execute(request);
        response.getShowAllBets().forEach(System.out::println);
        System.out.println("\nBet list end");
    }
}
