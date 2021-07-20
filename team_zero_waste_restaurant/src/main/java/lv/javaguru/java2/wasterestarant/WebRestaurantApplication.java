package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.console_ui.ProgramMenu;
import lv.javaguru.java2.wasterestarant.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebRestaurantApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);
        ProgramMenu programMenu = context.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumberFromAdmin();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }

}
