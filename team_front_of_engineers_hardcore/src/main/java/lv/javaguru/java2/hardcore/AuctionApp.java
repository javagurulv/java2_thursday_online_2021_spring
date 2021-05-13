package lv.javaguru.java2.hardcore;

import lv.javaguru.java2.hardcore.config.LotListConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.hardcore.consoleUI.ProgramMenu;




public class AuctionApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();

        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printAuctionMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(LotListConfiguration.class);
    }


}
