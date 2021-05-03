package lv.javaguru.java2.wasterestarant.core.services.acceptancetests;

//import lv.javaguru.java2.wasterestarant.dependency_injection.ApplicationContext;
//import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
//import lv.javaguru.java2.wasterestarant.core.requests.Paging;
//import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
//import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
//import lv.javaguru.java2.wasterestarant.core.responses.dish.SearchDishesResponse;
//import lv.javaguru.java2.wasterestarant.core.services.dish.AddDishService;
//import lv.javaguru.java2.wasterestarant.core.services.dish.SearchDishesService;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;

//Elena
public class AcceptanceTest1 {
//    private ApplicationContext applicationContext = new ApplicationContext();
//
//    @Test
//    public void searchDishes() {
//        AddDishRequest request1 = new AddDishRequest("Margherita", "Margherita", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request1);
//        AddDishRequest request2 = new AddDishRequest("Marinara", "Marinara", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request2);
//        SearchDishesRequest request3 = new SearchDishesRequest(null, "Pizza", 4.99);
//        SearchDishesResponse response = getSearchDishesService().execute(request3);
//        assertEquals(response.getDishes().size(), 2);
//        assertEquals(response.getDishes().get(0).getName(), "Margherita");
//        assertEquals(response.getDishes().get(0).getType(), "Pizza");
//        assertEquals(response.getDishes().get(1).getName(), "Marinara");
//        assertEquals(response.getDishes().get(1).getType(), "Pizza");
//    }
//
//    @Test
//    public void searchDishesOrderingDescending() {
//        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request1);
//        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request2);
//        Ordering ordering = new Ordering("name", "DESCENDING");
//        SearchDishesRequest request3 = new SearchDishesRequest(null, "Pizza", null, ordering);
//        SearchDishesResponse response = getSearchDishesService().execute(request3);
//        assertEquals(response.getDishes().size(), 2);
//        assertEquals(response.getDishes().get(0).getName(), "abc2");
//        assertEquals(response.getDishes().get(1).getName(), "abc1");
//    }
//
//    @Test
//    public void searchDishesOrderingAscending() {
//        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request1);
//        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request2);
//        Ordering ordering = new Ordering("name", "ASCENDING");
//        SearchDishesRequest request3 = new SearchDishesRequest(null, null, 4.99, ordering);
//        SearchDishesResponse response = getSearchDishesService().execute(request3);
//        assertEquals(response.getDishes().size(), 2);
//        assertEquals(response.getDishes().get(0).getName(), "abc1");
//        assertEquals(response.getDishes().get(1).getName(), "abc2");
//    }
//
//    @Test
//    public void searchDishesOrderingPaging() {
//        AddDishRequest request1 = new AddDishRequest("abc1", "Margherita", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request1);
//        AddDishRequest request2 = new AddDishRequest("abc2", "Marinara", "Pizza", 0.2, 4.99);
//        getAddDishService().execute(request2);
//        Ordering ordering = new Ordering("name", "ASCENDING");
//        Paging paging = new Paging(1, 1);
//        SearchDishesRequest request3 = new SearchDishesRequest(null, null, 4.99, ordering, paging);
//        SearchDishesResponse response = getSearchDishesService().execute(request3);
//        assertEquals(response.getDishes().size(), 1);
//        assertEquals(response.getDishes().get(0).getName(), "abc1");
//        assertEquals(response.getDishes().get(0).getDescription(), "Margherita");
//    }
//
//    private AddDishService getAddDishService() {
//        return applicationContext.getBean(AddDishService.class);
//    }
//
//    private SearchDishesService getSearchDishesService() {
//        return applicationContext.getBean(SearchDishesService.class);
//    }
}
