package lv.javaguru.java2.hrsystem.dependency_injection;

import lv.javaguru.java2.hrsystem.console_ui.*;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.*;
import lv.javaguru.java2.hrsystem.core.services.validators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public void addBean(Class beanClass, Object beanInstance) {
        beans.put(beanClass, beanInstance);
        Class[] instanceInterfaces = beanClass.getInterfaces();
        for (int i = 0; i < instanceInterfaces.length; i++) {
            Class instanceInterface = instanceInterfaces[i];
            Object instance = getBean(instanceInterface);
            if (instance == null) {
                beans.put(instanceInterface, beanInstance);
            }
        }
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}