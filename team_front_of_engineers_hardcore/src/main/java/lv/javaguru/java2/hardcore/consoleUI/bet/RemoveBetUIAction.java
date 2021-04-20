package lv.javaguru.java2.hardcore.consoleUI.bet;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.response.bet.RemoveBetResponse;
import lv.javaguru.java2.hardcore.response.lot.RemoveLotResponse;
import lv.javaguru.java2.hardcore.services.bet.RemoveBetService;

import java.util.Scanner;

public class RemoveBetUIAction implements UIAction {

    private RemoveBetService removeBetService;

    public RemoveBetUIAction(RemoveBetService removeBetService) {
        this.removeBetService = removeBetService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bet ID to remove it from list: ");
        Long id = scanner.nextLong();
        RemoveBetRequest request = new RemoveBetRequest(id);
        RemoveBetResponse response = removeBetService.execute(request);
        if(response.hasErrors()){
            response.getErrors().forEach(coreError -> System.out.println("Error: "+coreError.getField()+" "+coreError.getMessage()));
        }else {
            System.out.println("Lot with id :"+request.getBetIdToRemove()+" removing status is: "+response.isRemoved());
        } if (!response.isRemoved()){
            System.out.println("Such ID doesn't exist,please try again");
        }else {
            System.out.println("Lot with id: "+request.getBetIdToRemove()+" was removed,please check list for changes");
        }
    }
}
