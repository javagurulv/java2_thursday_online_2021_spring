package lv.javaguru.java2.wasterestarant;

import lv.javaguru.java2.wasterestarant.config.RestaurantApplicationConfiguration;
import lv.javaguru.java2.wasterestarant.console_ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();

        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.printProgramMenu();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }
    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(RestaurantApplicationConfiguration.class);
    }
}
