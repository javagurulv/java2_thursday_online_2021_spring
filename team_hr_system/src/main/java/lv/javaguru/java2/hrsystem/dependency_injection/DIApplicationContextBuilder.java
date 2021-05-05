package lv.javaguru.java2.hrsystem.dependency_injection;

import java.util.List;

public class DIApplicationContextBuilder {
    private ClassFinder classFinder = new ClassFinder();
    private DIComponentFilter componentFilter = new DIComponentFilter();
    private DIComponentCreator componentsCreator = new DIComponentCreator();
    private DIDependencyResolver dependencyResolver = new DIDependencyResolver();


    public ApplicationContext build(String packageName) {
        try {
            List<Class> classes = classFinder.findClassesInsidePackage(packageName);
            List<Class> diComponents = componentFilter.filter(classes);
            ApplicationContext context = new ApplicationContext();
            componentsCreator.create(context, diComponents);
            dependencyResolver.resolve(context, diComponents);
            return context;

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}