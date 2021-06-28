package lv.javaguru.java2.hardcore.consoleUI;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lv.javaguru.java2.hardcore.core.requests.bet.GetAllBetsForLotByLotIdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, LoginUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, AddUserUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, AddLotUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, AddBetUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, ShowAllBetsUIAction.class));
        menuNumberToUIActionMap.put(6, findUIAction(uiActions, GetAllLotsUIAction.class));
        menuNumberToUIActionMap.put(7, findUIAction(uiActions, ShowAllUsersUIAction.class));
        menuNumberToUIActionMap.put(8, findUIAction(uiActions, RemoveLotUIAction.class));
        menuNumberToUIActionMap.put(9, findUIAction(uiActions, RemoveBetUIAction.class));
        menuNumberToUIActionMap.put(10, findUIAction(uiActions, SearchLotByNameOrPriceUIAction.class));
        menuNumberToUIActionMap.put(11, findUIAction(uiActions, GetAllBetsForLotByLotIdUIAction.class));
        menuNumberToUIActionMap.put(12, findUIAction(uiActions, GetHighestBetForLotByLotIdUIAction.class));
        menuNumberToUIActionMap.put(0, findUIAction(uiActions, ExitUiAction.class));
    }


    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst().get();
    }

    public void printAuctionMenu() {
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
        System.out.println("10. Search lot by name and price");
        System.out.println("11. Show all bets for one lot");
        System.out.println("12. Show highest bet for lot with ID...");
        System.out.println("0. Exit");
        System.out.println();
    }

    public int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());

    }

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
