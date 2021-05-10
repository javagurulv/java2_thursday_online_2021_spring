package lv.javaguru.java2.hrsystem.dependency_injection_tests;

import lv.javaguru.java2.hrsystem.dependency_injection.ClassFinder;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponentFilter;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DIComponentFilterTest {

    @Test
    public void diComponentFilterTest() throws IOException, ClassNotFoundException {
        ClassFinder finder = new ClassFinder();
        DIComponentFilter filter = new DIComponentFilter();
        List<Class> classes = finder.findClassesInsidePackage("lv.javaguru.java2.hrsystem");
        List<Class> diComponents = filter.filter(classes);
        diComponents.forEach(aClass -> {
            System.out.println(aClass.getName());
        });
    }
}
