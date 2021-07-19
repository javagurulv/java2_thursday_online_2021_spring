package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.console_ui.AdminProgramMenu;
import lv.javaguru.java2.wasterestarant.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebRestaurantApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);
        AdminProgramMenu adminProgramMenu = context.getBean(AdminProgramMenu.class);
        while (true) {
            adminProgramMenu.printProgramMenu();
            int menuNumber = adminProgramMenu.getMenuNumberFromAdmin();
            adminProgramMenu.executeSelectedMenuItem(menuNumber);
        }
    }

}
