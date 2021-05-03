package lv.javaguru.java2.hrsystem.dependency_injection;

import java.util.List;

import static java.util.stream.Collectors.*;

public class DIComponentFilter {

    public List<Class> filter(List<Class> classes) {
        return classes.stream()
                .filter(cl -> cl.isAnnotationPresent(DIComponent.class))
                .collect(toList());
    }
}