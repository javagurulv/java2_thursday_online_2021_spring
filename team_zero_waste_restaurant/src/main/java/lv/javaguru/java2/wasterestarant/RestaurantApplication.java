package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.config.SpringCoreConfiguration;
import lv.javaguru.java2.wasterestarant.console_ui.AdminProgramMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();

        AdminProgramMenu adminProgramMenu = applicationContext.getBean(AdminProgramMenu.class);
        while (true) {
            adminProgramMenu.printProgramMenu();
            int menuNumber = adminProgramMenu.getMenuNumberFromAdmin();
            adminProgramMenu.executeSelectedMenuItem(menuNumber);
        }
    }
    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }
}
