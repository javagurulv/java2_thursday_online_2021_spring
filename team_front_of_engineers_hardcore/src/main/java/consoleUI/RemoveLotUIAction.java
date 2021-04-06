package consoleUI;

import Services.RemoveLotService;

import java.util.Scanner;

public class RemoveLotUIAction implements UIAction{
    private RemoveLotService removeLotService;

    public RemoveLotUIAction(RemoveLotService removeLotService) {
        this.removeLotService = removeLotService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lot ID to remove it from list: ");
        Long id = scanner.nextLong();
        removeLotService.execute(id);
        System.out.println("DataModels.Lot has been removed,please check lot list for changes");
    }
}
