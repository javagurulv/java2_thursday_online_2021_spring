package lv.javaguru.java2.wasterestarant.acceptancetests;

import lv.javaguru.java2.wasterestarant.DatabaseCleaner;
import lv.javaguru.java2.wasterestarant.config.RestaurantApplicationConfiguration;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.AddProductService;
import lv.javaguru.java2.wasterestarant.core.services.products.SearchProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

//AndrejsB
public class AcceptanceTest2 {

    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(RestaurantApplicationConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void searchProducts() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("name1", 3.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest request2 = new AddProductRequest("name1", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("name2", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);
        SearchProductRequest request4 = new SearchProductRequest("name1");
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getName(), "name1");
        assertEquals(response.getProducts().get(0).getQuantity(), 3.0, 0.001);
        assertEquals(response.getProducts().get(1).getName(), "name1");
        assertEquals(response.getProducts().get(1).getQuantity(), 5.0, 0.001);

    }

    @Test
    public void searchProductQuantityDescending() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("name1", 3.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest request2 = new AddProductRequest("name1", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("name2", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);

        Ordering ordering = new Ordering("Q", "DESC");
        SearchProductRequest request4 = new SearchProductRequest("name1", ordering);
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getName(), "name1");
        assertEquals(response.getProducts().get(0).getQuantity(), 5.0, 0.001);
        assertEquals(response.getProducts().get(1).getName(), "name1");
        assertEquals(response.getProducts().get(1).getQuantity(), 3.0, 0.001);

    }

    @Test
    public void searchProductQuantityAscending() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("name1", 9.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest request2 = new AddProductRequest("name1", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("name2", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);

        Ordering ordering = new Ordering("Q", "ASC");
        SearchProductRequest request4 = new SearchProductRequest("name1", ordering);
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getName(), "name1");
        assertEquals(response.getProducts().get(0).getQuantity(), 5.0, 0.001);
        assertEquals(response.getProducts().get(1).getName(), "name1");
        assertEquals(response.getProducts().get(1).getQuantity(), 9.0, 0.001);

    }

    @Test
    public void searchProductExpiryDateAscending() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("name1", 9.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2022"));
        AddProductRequest request2 = new AddProductRequest("name1", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("name2", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);

        Ordering ordering = new Ordering("BBD", "ASC");
        SearchProductRequest request4 = new SearchProductRequest("name1", ordering);
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getName(), "name1");
        assertEquals(response.getProducts().get(0).getExpiryDate(), new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        assertEquals(response.getProducts().get(1).getName(), "name1");
        assertEquals(response.getProducts().get(1).getExpiryDate(), new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2022"));

    }

    @Test
    public void searchProductQuantityPaging() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("name1", 9.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest request2 = new AddProductRequest("name1", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("name2", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);

        Ordering ordering = new Ordering("Q", "ASC");
        Paging paging = new Paging(1, 1);
        SearchProductRequest request4 = new SearchProductRequest("name1", ordering, paging);
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getName(), "name1");
        assertEquals(response.getProducts().get(0).getQuantity(), 5.0, 0.001);
    }


    private AddProductService getAddProductService() {
        return applicationContext.getBean(AddProductService.class);
    }

    private SearchProductService getSearchProductService() {
        return applicationContext.getBean(SearchProductService.class);
    }
    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }
}
