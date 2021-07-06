package lv.javaguru.java2.realestate.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//@Component
public class ProgramMenu {

    private Map<Integer, ConsoleUI> menuNumberToActionMap;

   // @Autowired
    public ProgramMenu(List<ConsoleUI> consoleUIS) {
        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, findUIAction(consoleUIS, ExitUIAction.class));
        menuNumberToActionMap.put(1, findUIAction(consoleUIS, CreateUserUIAction.class));
        menuNumberToActionMap.put(2, findUIAction(consoleUIS, LogInUIAction.class));
        menuNumberToActionMap.put(3, findUIAction(consoleUIS, CreateOfferUIAction.class));
        menuNumberToActionMap.put(4, findUIAction(consoleUIS, GetAllOffersUIAction.class));
        menuNumberToActionMap.put(5, findUIAction(consoleUIS, DeleteOfferUIAction.class));
        menuNumberToActionMap.put(6, findUIAction(consoleUIS, DeleteUserUIAction.class));
        menuNumberToActionMap.put(7, findUIAction(consoleUIS, SearchOffersUIAction.class));

    }

    private ConsoleUI findUIAction(List<ConsoleUI> consoleUIS, Class consoleUIClass) {
        return consoleUIS.stream()
                .filter(consoleUI -> consoleUI.getClass().equals(consoleUIClass))
                .findFirst()
                .get();
    }

    private void printMenu() {
        System.out.print("Choose available option : \n" + "\n" +
                "0  = Exit \n" +
                "1 = Create account \n" +
                "2 = Log in \n" +
                "3 = Create offer \n" +
                "4 = View all offers\n" +
                "5 = Delete offer\n" +
                "6 = Delete account\n" +
                "7 = Search offers\n" +
                "\n");
        System.out.println("Please enter menu number: ");
    }

    public void run() {
        System.out.println("Welcome! \n ");

        while (true) {
            printMenu();
            int userSelectedMenuNumber = getNumberFromUser();
            executeOption(userSelectedMenuNumber);
        }
    }

    public int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeOption(int userMenuChoice) {
        ConsoleUI consoleUI = menuNumberToActionMap.get(userMenuChoice);
        if (consoleUI != null) {
            consoleUI.execute();
        } else {
            System.out.println("Entered number does not exist in menu.");
        }
    }
}
