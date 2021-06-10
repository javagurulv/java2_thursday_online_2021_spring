package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.core.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.AddLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class AddLotUIAction implements UIAction {
    @Autowired
    private AddLotService addLotService;
    @Autowired
    private UserSession userSession;


    @Override
    public void execute() {
        if(userSession.isAuthorized()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter lot name: ");
            String lotName = scanner.nextLine();
            System.out.println("Enter lot price: ");
            BigDecimal lotPrice = scanner.nextBigDecimal();
            AddLotRequest request = new AddLotRequest(lotName, lotPrice);
            AddLotResponse response = addLotService.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
            } else {
                System.out.println("Your lot was added to list: " + "LotName='" + response.getNewLot().getName() + '\'' +
                        ", LotStartPrice=" + response.getNewLot().getStartPrice() +
                        ", IdOfUserWhoMadeLot=" + response.getNewLot().getUserID()+
                        '}');
            }
        }
        else {
            System.out.println("Please log in first!");
        }
    }
}
