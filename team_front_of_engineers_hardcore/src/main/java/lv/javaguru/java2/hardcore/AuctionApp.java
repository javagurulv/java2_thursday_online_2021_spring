package lv.javaguru.java2.hardcore;

import lv.javaguru.java2.hardcore.consoleUI.bet.AddBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.RemoveBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.ShowAllBetsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.AddLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.GetAllLotsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.RemoveLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.AddUserUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.LoginUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.ShowAllUsersUIAction;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.consoleUI.*;
import lv.javaguru.java2.hardcore.database.*;
import lv.javaguru.java2.hardcore.services.bet.*;
import lv.javaguru.java2.hardcore.services.lot.*;
import lv.javaguru.java2.hardcore.services.user.*;

import java.util.Scanner;

public class AuctionApp {
    private LotDatabase lotDatabase = new InMemoryLotDatabase();
    private UserDatabase userDatabase = new InMemoryUserDatabase();
    private BetDatabase betDatabase = new InMemoryBetDatabase();

    private AddLotValidator addLotValidator = new AddLotValidator();
    private RemoveLotValidator removeLotValidator = new RemoveLotValidator();
    private AddUserValidator addUserValidator = new AddUserValidator();
    private LoginValidator loginValidator = new LoginValidator();
    private AddBetValidator addBetValidator = new AddBetValidator();
    private RemoveBetValidator removeBetValidator = new RemoveBetValidator();

    private LoginService loginService = new LoginService(userDatabase, loginValidator);
    private AddUserService addUserService = new AddUserService(userDatabase, addUserValidator);
    private ShowAllUsersService showAllUsersService = new ShowAllUsersService(userDatabase);
    private AddLotService addLotService = new AddLotService(lotDatabase, addLotValidator,loginService);
    private GetAllLotsService getAllLotsService = new GetAllLotsService(lotDatabase);
    private RemoveLotService removeLotService = new RemoveLotService(lotDatabase, removeLotValidator);
    private AddBetService addBetService = new AddBetService(betDatabase, addBetValidator,loginService);
    private RemoveBetService removeBetService = new RemoveBetService(betDatabase, removeBetValidator);
    private ShowAllBetsService showAllBetsService = new ShowAllBetsService(betDatabase);


    private UIAction addBetUIAction = new AddBetUIAction(addBetService);
    private UIAction removeBetUIAction = new RemoveBetUIAction(removeBetService);
    private UIAction showAllBetsUIAction = new ShowAllBetsUIAction(showAllBetsService);
    private UIAction loginUIAction = new LoginUIAction(loginService);
    private UIAction addUserUIAction = new AddUserUIAction(addUserService);
    private UIAction showAllUsersUIAction = new ShowAllUsersUIAction(showAllUsersService);
    private UIAction addLotUIAction = new AddLotUIAction(addLotService);
    private UIAction getAllLotsUIAction = new GetAllLotsUIAction(getAllLotsService);
    private UIAction removeLotUIAction = new RemoveLotUIAction(removeLotService);
    private UIAction exitUIAction = new ExitUiAction();


    public static void main(String[] args) {

        AuctionApp auctionApp = new AuctionApp();
        auctionApp.run();
    }

    private void run() {
        while (true) {
            printAuctionMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectedMenuItem(menuNumber);

        }
    }


    private void printAuctionMenu() {
        System.out.println("User menu:");
        System.out.println("1. Login");
        System.out.println("2. Register new user");
        System.out.println("3. Add new lot to list");
        System.out.println("4. Add new bet to list");
        System.out.println("5. Show all bets from Bet list");
        System.out.println("6. Show all lots from Lot list");
        System.out.println("7. Show all users from User list");
        System.out.println("8. Remove lot from the list");
        System.out.println("9. Remove bet from the list");
        System.out.println("0. Exit");
        System.out.println(" ");
    }

    private int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());

    }

    private void executeSelectedMenuItem(int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                loginUIAction.execute();
                break;
            }
            case 2: {
                addUserUIAction.execute();
                break;
            }
            case 3: {
                addLotUIAction.execute();
                break;
            }
            case 4: {
                addBetUIAction.execute();
                break;

            }
            case 5: {
                showAllBetsUIAction.execute();
                break;

            }
            case 6: {
                getAllLotsUIAction.execute();
                break;
            }
            case 7: {
                showAllUsersUIAction.execute();
                break;
            }
            case 8: {
                removeLotUIAction.execute();
                break;
            }
            case 9: {
                removeBetUIAction.execute();
                break;
            }

            case 0: {
                exitUIAction.execute();
                break;
            }
        }
    }
//    private void printLoginMenu() {
//        System.out.println("Start menu");
//        System.out.println("1. Log in");
//        System.out.println("2. Register");
//        System.out.println("3. Exit program");
//        System.out.println(" ");
//    }

//    private void executeSelectedStartMenu(int selectedMenu) {
//        switch (selectedMenu) {
//            case 1: {
//                loginUIAction.execute();
//                break;
//                }
//            case 2: {
//                addUserUIAction.execute();
//                break;
//            }
//            case 3: {
//                exitUIAction.execute();
//                break;
//            }
//
//        }
//    }


}
