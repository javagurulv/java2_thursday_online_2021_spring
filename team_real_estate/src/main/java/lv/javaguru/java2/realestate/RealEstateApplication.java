package lv.javaguru.java2.realestate;

import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import org.springframework.boot.SpringApplication;


class RealEstateApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RealEstateConfiguration.class);
        application.run(args);

  /*   //Console app setup
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
    } */
    }
}
