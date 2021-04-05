package servicesTest;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.Offer;
import org.junit.Assert;
import org.junit.Test;
import services.ViewAllOffersService;

import java.util.ArrayList;
import java.util.List;

public class ViewAllOffersServiceTest {
    Offer offer = new Offer("Buy", "House", "ABC", 10);
    Database database = new InMemoryDatabaseImpl();
    List<Offer> actual = new ViewAllOffersService().execute();
    List<Offer> expected = new ArrayList<>();

    @Test
    public void testExecuteTrue() {
        List<Offer> expected = new ArrayList<>();
        database.createOffer(offer);
        expected.add(offer);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testExecuteEmpty() {
        database.deleteOffer(offer);
        expected.clear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExecuteFalse() {
        expected.add(offer);

        Assert.assertNotEquals(expected.toString(), actual.toString());
    }
}