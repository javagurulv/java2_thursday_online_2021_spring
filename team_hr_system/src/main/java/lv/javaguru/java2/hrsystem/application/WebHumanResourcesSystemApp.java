package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.web_ui.config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class WebHumanResourcesSystemApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);

    }
}
