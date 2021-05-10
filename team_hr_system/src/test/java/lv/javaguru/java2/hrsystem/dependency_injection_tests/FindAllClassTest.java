package lv.javaguru.java2.hrsystem.dependency_injection_tests;

import lv.javaguru.java2.hrsystem.dependency_injection.ClassFinder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FindAllClassTest {

    @Test
    public void findAllClassTest() throws IOException, ClassNotFoundException {
        ClassFinder finder = new ClassFinder();
        List<Class> allClass = finder.findClassesInsidePackage("lv.javaguru.java2.hrsystem");
        allClass.stream().forEach(aClass -> System.out.println(aClass.getName()));
    }
}
