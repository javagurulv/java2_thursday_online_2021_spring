package lv.javaguru.java2.wasterestarant.dependency_injection;


import org.junit.Test;

import java.io.IOException;
import java.util.List;
//AndrejsB
public class DIComponentFilterTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        DIComponentFilter filter = new DIComponentFilter();
        List<Class> classes = classFinder.findClassesInsidePackage("lv.javaguru.java2.wasterestarant");
        List<Class> diComponents = filter.filter(classes);

        diComponents.forEach(aClass -> {
            System.out.println(aClass.getName());
        });
    }
}
