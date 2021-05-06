package lv.javaguru.java2.wasterestarant.dependency_injection;

import lv.javaguru.java2.wasterestarant.dependency_injection.testClass.TestClassForClassCreator;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
//AndrejsB
public class DIComponentCreatorTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        ApplicationContext applicationContext = new ApplicationContext();
        DIComponentCreator diComponentCreator = new DIComponentCreator();
        DIComponentFilter filter = new DIComponentFilter();
        ClassFinder classFinder = new ClassFinder();
        List<Class> classes = classFinder.findClassesInsidePackage("lv.javaguru.java2.wasterestarant." +
                "dependency_injection.testClass");
        List<Class> diComponents = filter.filter(classes);
        diComponentCreator.create(applicationContext, diComponents);

//        assertEquals(new TestClassForClassCreator(), applicationContext.getBean(TestClassForClassCreator.class));
//        assertEquals(TestClassForClassCreator.class, applicationContext.getBean(TestClassForClassCreator.class));
    }
}