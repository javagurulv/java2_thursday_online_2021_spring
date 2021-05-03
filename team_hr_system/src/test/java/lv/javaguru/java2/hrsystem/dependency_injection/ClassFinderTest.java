package lv.javaguru.java2.hrsystem.dependency_injection;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClassFinderTest {

    @Test
    public void testAllClassesInPackage() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        List<Class> allClasses = classFinder.findClassesInsidePackage("lv.javaguru.java2.hrsystem");
        allClasses.forEach(c -> System.out.println(c.getName()));
    }
}