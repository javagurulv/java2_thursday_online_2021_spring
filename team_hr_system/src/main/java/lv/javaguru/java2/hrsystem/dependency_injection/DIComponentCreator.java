package lv.javaguru.java2.hrsystem.dependency_injection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DIComponentCreator {

    public void create(ApplicationContext applicationContext, List<Class> diComponents) {
        diComponents.forEach(diComponent -> {
            Optional<Constructor> defaultConstructor = getDefaultConstructor(diComponent);
            if (defaultConstructor.isPresent()) {
                Object object = createObject(defaultConstructor.get());
                applicationContext.addBean(diComponent, object);
            } else {
                throw new RuntimeException("Class do not have default constructor!");
            }
        });
    }

    private Optional<Constructor> getDefaultConstructor(Class diComponent) {
        return Arrays.stream(diComponent.getConstructors())
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findFirst();
    }

    private Object createObject(Constructor constructor) {
        try {
            return constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}