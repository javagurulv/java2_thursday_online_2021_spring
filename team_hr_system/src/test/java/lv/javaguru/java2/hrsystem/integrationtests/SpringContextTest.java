package lv.javaguru.java2.hrsystem.integrationtests;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class) - аннотация для запуска тестов под управлением
//        специального Spring JUnit Runner класса, который обеспечивает поднятие Spring контекста
//        при старте тестов.
//
//@ContextConfiguration(classes = {BookListConfiguration.class}) - эта аннотация
//        позволяет указать главный класс с конфигурацией приложения.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HumanResourcesSystemConfiguration.class})
public class SpringContextTest {

    @Autowired private ApplicationContext appContext;

    @Test
    public void start() {
        assertNotNull(appContext);
    }

}
