package lv.javaguru.java2.hardcore.consoleUI.lot;

import lv.javaguru.java2.hardcore.consoleUI.UIAction;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.services.lot.AddLotService;

import java.math.BigDecimal;
import java.util.Scanner;

public class AddLotUIAction implements UIAction {

    private AddLotService addLotService;

    public AddLotUIAction(AddLotService addLotService) {
        this.addLotService = addLotService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot name: ");
        String lotName = scanner.nextLine();
        System.out.println("Enter lot price: ");
        BigDecimal lotPrice = scanner.nextBigDecimal();
        AddLotRequest request = new AddLotRequest(lotName,lotPrice);
        AddLotResponse response = addLotService.execute(request);
        if(response.hasErrors()){
            response.getErrors().forEach(coreError -> System.out.println("Error: "+coreError.getField()+" "+coreError.getMessage() ));
        }else {
            System.out.println("Your lot was: "+response.getNewLot());
            System.out.println("Your lot was added to list.");
        }
    }
}
