package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.config.SpringCoreConfiguration;
import lv.javaguru.java2.hrsystem.console_ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HumanResourcesSystemApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        LoginMenu loginMenu = applicationContext.getBean(LoginMenu.class);
        loginMenu.run();
    }


    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }

}