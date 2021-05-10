package lv.javaguru.java2.hrsystem.dependency_injection_tests;

import lv.javaguru.java2.hrsystem.dependency_injection.ApplicationContext;
import lv.javaguru.java2.hrsystem.dependency_injection.ClassFinder;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponentCreator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponentFilter;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DIComponentCreatorTest {

    @Test
    public void diComponentCreatorTest() throws IOException, ClassNotFoundException {
        ClassFinder classes = new ClassFinder();
        DIComponentFilter filter = new DIComponentFilter();
        DIComponentCreator componentCreator = new DIComponentCreator();
        List<Class> diComponent = filter.filter(classes.findClassesInsidePackage("lv.javaguru.java2.hrsystem"));
        componentCreator.create(new ApplicationContext(), diComponent);
        diComponent.stream().forEach(aClass -> System.out.println(aClass.getName()));

    }
}
