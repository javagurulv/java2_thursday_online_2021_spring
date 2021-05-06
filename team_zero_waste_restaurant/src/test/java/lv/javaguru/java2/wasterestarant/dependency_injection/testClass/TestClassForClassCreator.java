package lv.javaguru.java2.wasterestarant.dependency_injection.testClass;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
//AndrejsB
@DIComponent
public class TestClassForClassCreator {

    @DIDependency private Database database;

}
