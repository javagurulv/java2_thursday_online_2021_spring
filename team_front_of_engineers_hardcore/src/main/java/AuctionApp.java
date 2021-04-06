import Database.LotDatabase;
import Services.AddLotService;
import Services.GetAllLotsService;
import Services.RemoveLotService;
import consoleUI.*;
import Database.*;

import java.util.Scanner;

public class AuctionApp {
    private static LotDatabase lotDatabase = new InMemoryLotDatabase();
    private static AddLotService addLotService = new AddLotService(lotDatabase);
    private static GetAllLotsService getAllLotsService = new GetAllLotsService(lotDatabase);
    private static RemoveLotService removeLotService = new RemoveLotService(lotDatabase);
    private static UIAction addLotUIAction = new AddLotUIAction(addLotService);
    private static UIAction getAllLotsUIAction = new GetAllLotsUIAction(getAllLotsService);
    private static UIAction removeLotUIAction = new RemoveLotUIAction(removeLotService);
    private static UIAction exitUIAction = new ExitUiAction();


    public static void main(String[] args) {

        while (true) {
            printAuctionMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectedMenuItem(menuNumber);

        }
    }

    private static void printAuctionMenu() {
        System.out.println("User menu:");
        System.out.println("1. Add lot to list");
        System.out.println("2. Delete lot from list");
        System.out.println("3. Show all lots in the list");
        System.out.println("4. Exit");
        System.out.println(" ");

    }


    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());

    }



    private static void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addLotUIAction.execute();
                break;
            }
            case 2: {
                removeLotUIAction.execute();
                break;
            }
            case 3: {
                getAllLotsUIAction.execute();
                break;
            }
            case 4: {
                exitUIAction.execute();
                break;
            }
        }
    }

}
