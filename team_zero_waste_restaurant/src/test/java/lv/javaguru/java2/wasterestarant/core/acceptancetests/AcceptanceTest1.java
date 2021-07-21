package lv.javaguru.java2.wasterestarant.core.acceptancetests;

import lv.javaguru.java2.wasterestarant.core.DatabaseCleaner;
import lv.javaguru.java2.wasterestarant.config.SpringCoreConfiguration;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.core.services.dish.AddDishService;
import lv.javaguru.java2.wasterestarant.core.services.dish.SearchDishesService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest1 {

    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void searchDishes() {
        AddDishRequest addRequest1 = new AddDishRequest("Margherita", "Margherita", "Pizza", 0.2, 4.5);
        getAddDishService().execute(addRequest1);
        AddDishRequest addRequest2 = new AddDishRequest("Marinara", "Marinara", "Pizza", 0.2, 4.5);
        getAddDishService().execute(addRequest2);
        SearchDishesRequest searchRequest = new SearchDishesRequest("", "", 4.5);
        SearchDishesResponse response = getSearchDishesService().execute(searchRequest);
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
        assertEquals(response.getDishes().get(1).getName(), "Marinara");
        assertEquals(response.getDishes().get(1).getType(), "Pizza");
    }

    @Test
    public void searchDishesOrderingDescending() {
        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request1);
        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request2);
        Ordering ordering = new Ordering("name", "DESCENDING");
        SearchDishesRequest request3 = new SearchDishesRequest(null, "Pizza", null, ordering);
        SearchDishesResponse response = getSearchDishesService().execute(request3);
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "abc2");
        assertEquals(response.getDishes().get(1).getName(), "abc1");
    }

    @Test
    public void searchDishesOrderingAscending() {
        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request1);
        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request2);
        Ordering ordering = new Ordering("name", "ASCENDING");
        SearchDishesRequest request3 = new SearchDishesRequest(null, "Pizza", null, ordering);
        SearchDishesResponse response = getSearchDishesService().execute(request3);
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "abc1");
        assertEquals(response.getDishes().get(1).getName(), "abc2");
    }

    @Test
    public void searchDishesOrderingPaging() {
        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request1);
        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
        getAddDishService().execute(request2);
        Ordering ordering = new Ordering("name", "ASCENDING");
        Paging paging = new Paging(1, 1);
        SearchDishesRequest request3 = new SearchDishesRequest(null, "Pizza", null, ordering, paging);
        SearchDishesResponse response = getSearchDishesService().execute(request3);
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "abc1");
        assertEquals(response.getDishes().get(0).getDescription(), "Margherita");
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }

    private AddDishService getAddDishService() {
        return applicationContext.getBean(AddDishService.class);
    }

    private SearchDishesService getSearchDishesService() {
        return applicationContext.getBean(SearchDishesService.class);
    }
}
