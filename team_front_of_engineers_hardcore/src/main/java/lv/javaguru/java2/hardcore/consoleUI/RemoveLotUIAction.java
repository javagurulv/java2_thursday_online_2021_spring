package lv.javaguru.java2.hardcore.consoleUI;

import lv.javaguru.java2.hardcore.services.RemoveLotService;

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
        System.out.println("lv.javaguru.java2.hardcore.DataModels.Lot has been removed,please check lot list for changes");
    }
}
