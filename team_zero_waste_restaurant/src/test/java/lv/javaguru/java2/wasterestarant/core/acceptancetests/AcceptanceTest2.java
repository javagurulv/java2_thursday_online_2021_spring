package lv.javaguru.java2.wasterestarant.core.acceptancetests;

import lv.javaguru.java2.wasterestarant.core.DatabaseCleaner;
import lv.javaguru.java2.wasterestarant.config.SpringCoreConfiguration;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.AddProductService;
import lv.javaguru.java2.wasterestarant.core.services.products.GetAllProductsService;
import lv.javaguru.java2.wasterestarant.core.services.products.RemoveProductService;
import lv.javaguru.java2.wasterestarant.core.services.products.SearchProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest2 {

    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void searchProducts() throws ParseException {
        AddProductRequest request1 = new AddProductRequest("Cheese", 3.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest request2 = new AddProductRequest("Sugar", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest request3 = new AddProductRequest("Salt", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));

        getAddProductService().execute(request1);
        getAddProductService().execute(request2);
        getAddProductService().execute(request3);
        SearchProductRequest request4 = new SearchProductRequest("Cheese");
        SearchProductResponse response = getSearchProductService().execute(request4);

        assertEquals(response.getProducts().size(), 1);
        assertEquals(response.getProducts().get(0).getName(), "Cheese");
        assertEquals(response.getProducts().get(0).getQuantity(), 3.0, 0.001);
    }

    @Test
    public void deleteProduct() throws ParseException {
        AddProductRequest addRequest1 = new AddProductRequest("Cheese", 3.0, 1.0, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        AddProductRequest addRequest2 = new AddProductRequest("Sugar", 5.0, 1.7, new SimpleDateFormat("dd/MM/yyyy")
                .parse("01/09/2021"));
        AddProductRequest addRequest3 = new AddProductRequest("Salt", 7.0, 1.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/07/2021"));
        getAddProductService().execute(addRequest1);
        getAddProductService().execute(addRequest2);
        getAddProductService().execute(addRequest3);

        GetAllProductsRequest getRequest1 = new GetAllProductsRequest();
        GetAllProductsResponse getProductsResponse1 = getAllProductsService().execute(getRequest1);

        assertEquals(getProductsResponse1.getProducts().size(), 3);
        assertEquals(getProductsResponse1.getProducts().get(0).getName(), "Cheese");
        assertEquals(getProductsResponse1.getProducts().get(1).getName(), "Sugar");
        assertEquals(getProductsResponse1.getProducts().get(2).getName(), "Salt");

        RemoveProductRequest removeRequest = new RemoveProductRequest("Cheese");
        removeProductService().execute(removeRequest);

        GetAllProductsRequest getRequest2 = new GetAllProductsRequest();
        GetAllProductsResponse getProductsResponse2 = getAllProductsService().execute(getRequest2);

        assertEquals(getProductsResponse2.getProducts().size(), 2);
        assertEquals(getProductsResponse2.getProducts().get(0).getName(), "Sugar");
        assertEquals(getProductsResponse2.getProducts().get(1).getName(), "Salt");
    }

    private AddProductService getAddProductService() {
        return applicationContext.getBean(AddProductService.class);
    }

    private GetAllProductsService getAllProductsService() {
        return applicationContext.getBean(GetAllProductsService.class);
    }

    private RemoveProductService removeProductService() {
        return applicationContext.getBean(RemoveProductService.class);
    }

    private SearchProductService getSearchProductService() {
        return applicationContext.getBean(SearchProductService.class);
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }
}
