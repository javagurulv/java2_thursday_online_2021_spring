package lv.javaguru.java2.wasterestarant.dependency_injection;


import org.junit.Test;

import java.io.IOException;
import java.util.List;
//AndrejsB
public class ClassFinderTest {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        List<Class> classes = classFinder.findClassesInsidePackage("lv.javaguru.java2.wasterestarant");
        classes.forEach(aClass -> {
            System.out.println(aClass.getName());
        });
    }
}
