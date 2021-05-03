package lv.javaguru.java2.realestate.dependency_injection;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DIComponentFilterTest {
    @Test
    public void shouldReturnClassesWithDIComponentAnnotation() throws IOException, ClassNotFoundException {
        ClassFinder classFinder = new ClassFinder();
        DIComponentFilter componentFilter = new DIComponentFilter();
        List<Class> filteredClasses = componentFilter
                .filter(classFinder.findClassesInsidePackage("lv.javaguru.java2.realestate"));
        filteredClasses.stream()
                .forEach(aClass -> System.out.println(aClass.toString()));
    }
}