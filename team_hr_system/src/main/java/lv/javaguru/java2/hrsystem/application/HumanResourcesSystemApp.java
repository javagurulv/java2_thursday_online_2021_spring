package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import lv.javaguru.java2.hrsystem.console_ui.UIProgramMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HumanResourcesSystemApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = createApplicationContext();

        UIProgramMenu programMenu = applicationContext.getBean(UIProgramMenu.class);

        while (true) {
            programMenu.print();
            int menuNumber = programMenu.getMenuNumberFromUser();
            programMenu.executeSelectedMenuItem(menuNumber);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(HumanResourcesSystemConfiguration.class);
    }

}