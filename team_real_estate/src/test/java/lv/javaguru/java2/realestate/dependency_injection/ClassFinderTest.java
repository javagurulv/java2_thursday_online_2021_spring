package lv.javaguru.java2.realestate.dependency_injection;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClassFinderTest {
    @Test
    public void shouldFindClassesInsidePackage() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        List<Class> classes = classFinder.findClassesInsidePackage("lv.javaguru.java2.realestate");
        classes.stream().forEach(aClass -> System.out.println(aClass.toString()));
    }
}