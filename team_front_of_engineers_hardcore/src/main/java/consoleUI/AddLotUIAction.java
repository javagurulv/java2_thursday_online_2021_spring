package consoleUI;

import Services.AddLotService;

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
        System.out.println("Enter book price: ");
        BigDecimal lotPrice = scanner.nextBigDecimal();
        addLotService.execute(lotName,lotPrice);
        System.out.println("Your lot was added to list.");
    }
}
