package lv.javaguru.java2.realestate.dependency_injection;

import java.util.List;
import java.util.stream.Collectors;

public class DIComponentFilter {
    public List<Class> filter(List<Class> classes) {
        return classes.stream()
                .filter(a -> a.isAnnotationPresent(DIComponent.class))
                .collect(Collectors.toList());
    }
}
