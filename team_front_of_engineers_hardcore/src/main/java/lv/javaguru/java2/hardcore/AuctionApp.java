package lv.javaguru.java2.hardcore;

import lv.javaguru.java2.hardcore.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import lv.javaguru.java2.hardcore.consoleUI.ProgramMenu;



@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class AuctionApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringWebConfiguration.class);

        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printAuctionMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }


}
