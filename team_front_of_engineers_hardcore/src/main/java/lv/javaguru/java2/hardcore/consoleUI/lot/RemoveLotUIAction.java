package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;

import lv.javaguru.java2.hardcore.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.response.lot.RemoveLotResponse;
import lv.javaguru.java2.hardcore.services.lot.RemoveLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveLotUIAction implements UIAction {

    @Autowired
    private RemoveLotService removeLotService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot ID to remove it from list: ");
        Long id = scanner.nextLong();
        RemoveLotRequest request = new RemoveLotRequest(id);
        RemoveLotResponse response = removeLotService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Lot with id :" + request.getLotIdToRemove() + " removing status is: " + response.isRemoved());
        }
        if (!response.isRemoved()) {
            System.out.println("Such ID doesn't exist,please try again");
        } else {
            System.out.println("Lot with id: " + request.getLotIdToRemove() + " was removed,please check list for changes");
        }

    }
}
