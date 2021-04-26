package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

// AndrejsB
@RunWith(MockitoJUnitRunner.class)
public class SearchProductServiceTestMock {

    @Mock
    private Database database;
    @Mock
    private SearchProductServiceValidator validator;

    @InjectMocks
    private SearchProductService service;

    @Test
    public void shouldSearchByName() throws ParseException {
        SearchProductRequest request = new SearchProductRequest("name");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("name", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021")));
        Mockito.when(database.searchProductByName("name")).thenReturn(products);

        SearchProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getName(), "name");
    }

    @Test
    public void shouldReturnErrorWhenSearchNameIsEmpty() {
        SearchProductRequest request = new SearchProductRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("name", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchProductResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(),1);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void searchByQuantityWithOrderingDescending() throws ParseException {
        Ordering ordering = new Ordering("Q", "DESC");
        SearchProductRequest request = new SearchProductRequest("name", ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("name", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021")));
        products.add(new Product("name", 4.0, 0.9, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/06/2022")));
        Mockito.when(database.searchProductByName("name")).thenReturn(products);

        SearchProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(1).getQuantity(), 3.0, 0.001);
    }

    @Test
    public void searchByExpiryDayWithOrderingAscending() throws ParseException {
        Ordering ordering = new Ordering("BBD", "ASC");
        SearchProductRequest request = new SearchProductRequest("name", ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("name", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021")));
        products.add(new Product("name", 4.0, 0.9, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/06/2022")));
        Mockito.when(database.searchProductByName("name")).thenReturn(products);

        SearchProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 2);
        assertEquals(response.getProducts().get(0).getExpiryDate(), new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021"));
    }

    @Test
    public void shouldSearchByNameWithPagingFirstPage() throws ParseException {
        Paging paging = new Paging(1, 1);
        SearchProductRequest request = new SearchProductRequest("name",3.0, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("name", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021")));
        products.add(new Product("name", 4.0, 0.9, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/06/2022")));
        Mockito.when(database.searchProductByName("name")).thenReturn(products);

        SearchProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getQuantity(), 3.0, 0.001);
    }

    @Test
    public void shouldSearchByNameWithPagingSecondPage() throws ParseException {
        Paging paging = new Paging(2, 1);
        SearchProductRequest request = new SearchProductRequest("name",3.0, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Product> products = new ArrayList<>();
        products.add(new Product("name", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021")));
        products.add(new Product("name", 4.0, 0.9, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/06/2022")));
        Mockito.when(database.searchProductByName("name")).thenReturn(products);

        SearchProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getQuantity(), 4.0, 0.001);
    }

}
