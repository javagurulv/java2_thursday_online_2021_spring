package lv.javaguru.java2.hrsystem.dependency_injection;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DIComponentFilterTest {
    private DIComponentFilter diComponentFilter = new DIComponentFilter();
    private ClassFinder classFinder = new ClassFinder();

    @Test
    public void testClassesWithDIComponent() throws IOException, ClassNotFoundException {
        List<Class> allClasses = classFinder.findClassesInsidePackage("lv.javaguru.java2.hrsystem");
        List<Class> diClasses = diComponentFilter.filter(allClasses);
        diClasses.forEach(c -> System.out.println(c.getName()));
    }
}