package lv.javaguru.java2.realestate;

import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import lv.javaguru.java2.realestate.console_ui.ProgramMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class RealEstateApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = createApplicationContext();
        ProgramMenu programMenu = applicationContext.getBean(ProgramMenu.class);
        while (true) {
            programMenu.run();
            int menuNumber = programMenu.getNumberFromUser();
            programMenu.executeOption(menuNumber);
        }
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(RealEstateConfiguration.class);
    }
}
