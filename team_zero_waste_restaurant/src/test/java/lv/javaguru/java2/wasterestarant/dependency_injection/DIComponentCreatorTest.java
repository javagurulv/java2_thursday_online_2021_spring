package lv.javaguru.java2.wasterestarant.dependency_injection;

import lv.javaguru.java2.wasterestarant.dependency_injection.testClass.TestClassForClassCreator;
import lv.javaguru.java2.wasterestarant.dependency_injection.testClass.TestClassForClassCreator2;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//AndrejsB
public class DIComponentCreatorTest {

    private ApplicationContext applicationContext = new ApplicationContext();
    private DIComponentCreator diComponentCreator = new DIComponentCreator();
    private List<Class> classes;

    @Before
    public void setUp() {
        classes = new ArrayList<>();
        classes.add(TestClassForClassCreator.class);
        classes.add(TestClassForClassCreator2.class);

    }


    @Test
    public void test() throws IOException, ClassNotFoundException {
        diComponentCreator.create(applicationContext, classes);
        assertEquals(new TestClassForClassCreator(), applicationContext.getBean(TestClassForClassCreator.class));
        assertEquals(new TestClassForClassCreator2(), applicationContext.getBean(TestClassForClassCreator2.class));
    }


    @DIComponent
    public static class TestClassForClassCreator {
        @Override
        public boolean equals(Object obj) {
            return obj instanceof TestClassForClassCreator;
        }
    }
    @DIComponent
    public static class TestClassForClassCreator2 {
        @Override
        public boolean equals(Object obj) {
            return obj instanceof TestClassForClassCreator2;
        }
    }
}