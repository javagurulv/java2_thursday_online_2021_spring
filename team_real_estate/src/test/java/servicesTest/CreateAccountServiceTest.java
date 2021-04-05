package servicesTest;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.Offer;
import domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountServiceTest  {
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