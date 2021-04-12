package lv.javaguru.java2.realestate;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.Offer;
import lv.javaguru.java2.realestate.domain.User;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateUserServiceTest {
    User user = new User("John","Doe");
    Database database = new InMemoryDatabaseImpl();

    List<Offer> expected = new ArrayList<>();

    @Test
    public void testExecuteTrue() {

    }

    @Test
    public void testExecuteFalse(){

    }
}