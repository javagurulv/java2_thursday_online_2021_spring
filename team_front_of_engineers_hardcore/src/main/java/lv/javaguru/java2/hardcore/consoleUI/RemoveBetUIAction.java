package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.core.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.core.response.bet.RemoveBetResponse;
import lv.javaguru.java2.hardcore.core.services.bet.RemoveBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveBetUIAction implements UIAction {

    @Autowired
    private RemoveBetService removeBetService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bet ID to remove it from list: ");
        Long id = scanner.nextLong();
        RemoveBetRequest request = new RemoveBetRequest(id);
        RemoveBetResponse response = removeBetService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Lot with id :" + request.getBetIdToRemove() + " removing status is: " + response.isRemoved());
        }
        if (!response.isRemoved()) {
            System.out.println("Such ID doesn't exist,please try again");
        } else {
            System.out.println("Lot with id: " + request.getBetIdToRemove() + " was removed,please check list for changes");
        }
    }
}
