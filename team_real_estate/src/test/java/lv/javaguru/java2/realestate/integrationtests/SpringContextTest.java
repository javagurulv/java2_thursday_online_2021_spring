package lv.javaguru.java2.realestate.integrationtests;


import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RealEstateConfiguration.class})
public class SpringContextTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void start() {
        assertNotNull(applicationContext);
    }

}
