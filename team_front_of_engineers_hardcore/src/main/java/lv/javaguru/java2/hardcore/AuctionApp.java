package lv.javaguru.java2.hardcore;

import lv.javaguru.java2.hardcore.consoleUI.bet.AddBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.RemoveBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.ShowAllBetsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.AddLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.GetAllLotsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.RemoveLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.SearchLotByNameOrPriceUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.AddUserUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.LoginUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.ShowAllUsersUIAction;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.consoleUI.*;
import lv.javaguru.java2.hardcore.database.*;
import lv.javaguru.java2.hardcore.services.bet.*;
import lv.javaguru.java2.hardcore.services.lot.*;
import lv.javaguru.java2.hardcore.services.user.*;

import java.security.SecureRandom;
import java.util.Scanner;

public class AuctionApp {

    private ApplicationContext applicationContext = new ApplicationContext();


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
        System.out.println("10. Search lot by name");
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
                LoginUIAction loginUIAction = applicationContext.getBean(LoginUIAction.class);
                loginUIAction.execute();
                break;
            }
            case 2: {
                AddUserUIAction addUserUIAction = applicationContext.getBean(AddUserUIAction.class);
                addUserUIAction.execute();
                break;
            }
            case 3: {
                AddLotUIAction addLotUIAction = applicationContext.getBean(AddLotUIAction.class);
                addLotUIAction.execute();
                break;
            }
            case 4: {
                AddBetUIAction addBetUIAction = applicationContext.getBean(AddBetUIAction.class);
                addBetUIAction.execute();
                break;

            }
            case 5: {
                ShowAllBetsUIAction showAllBetsUIAction = applicationContext.getBean(ShowAllBetsUIAction.class);
                showAllBetsUIAction.execute();
                break;

            }
            case 6: {
                GetAllLotsUIAction getAllLotsUIAction = applicationContext.getBean(GetAllLotsUIAction.class);
                getAllLotsUIAction.execute();
                break;
            }
            case 7: {
                ShowAllUsersUIAction showAllUsersUIAction = applicationContext.getBean(ShowAllUsersUIAction.class);
                showAllUsersUIAction.execute();
                break;
            }
            case 8: {
                RemoveLotUIAction removeLotUIAction = applicationContext.getBean(RemoveLotUIAction.class);
                removeLotUIAction.execute();
                break;
            }
            case 9: {
                RemoveBetUIAction removeBetUIAction = applicationContext.getBean(RemoveBetUIAction.class);
                removeBetUIAction.execute();
                break;
            }case 10: {
                SearchLotByNameOrPriceUIAction searchLotByNameOrPriceUIAction = applicationContext.getBean(SearchLotByNameOrPriceUIAction.class);
                searchLotByNameOrPriceUIAction.execute();
                break;
            }

            case 0: {
                ExitUiAction exitUiAction = applicationContext.getBean(ExitUiAction.class);
                exitUiAction.execute();
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
