package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
//AndrejsB
public class SearchProductServiceTest {


    private Database database = new InMemoryDatabaseImpl();
    private SearchProductServiceValidator validator = new SearchProductServiceValidator();
    private SearchProductService service = new SearchProductService(database, validator);

    @Before
    public void setUp() throws ParseException {

        Product onion1 = new Product("onion", 2.0, 0.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        Product onion2 = new Product("onion", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021"));
        Product flour = new Product("flour", 3.0, 0.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/10/2021"));
        Product sugar = new Product("sugar", 8.0, 0.55, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/08/2022"));

        database.save(onion1);
        database.save(onion2);
        database.save(flour);
        database.save(sugar);
    }

    @Test
    public void searchWithoutAnything() {
        SearchProductRequest request = new SearchProductRequest("onion");
        SearchProductResponse response = service.execute(request);
        assertEquals(response.getProducts().size(), 2);
    }

    @Test
    public void searchByQuantityDescending() {
        Ordering ordering = new Ordering("Q", "DESC");
        SearchProductRequest request = new SearchProductRequest("onion", ordering);
        SearchProductResponse response = service.execute(request);
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getQuantity(), 3.0, 0.001);
    }

    @Test
    public void searchByExpiryDateAscending() throws ParseException {
        Ordering ordering = new Ordering("BBD", "ASC");
        SearchProductRequest request = new SearchProductRequest("onion", ordering);
        SearchProductResponse response = service.execute(request);
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getExpiryDate(), new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021"));
    }


}