package lv.javaguru.java2.wasterestarant.core.services.acceptancetests;

import lv.javaguru.java2.wasterestarant.dependency_injection.ApplicationContext;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.AddDishIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.AddDishIngredientService;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.SearchIngredientService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest3 {

    private ApplicationContext applicationContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.wasterestarant");

    private AddDishIngredientService getDishIngredientService() {
        return applicationContext.getBean(AddDishIngredientService.class);
    }

    private SearchIngredientService getSearchIngredientService() {
        return applicationContext.getBean(SearchIngredientService.class);
    }

    @Test
    public void searchIngredients(){
        AddDishIngredientRequest requestOne = new AddDishIngredientRequest("Tomato", 1.0 );
        AddDishIngredientRequest requestTwo = new AddDishIngredientRequest("Tomato", 2.0 );
        getDishIngredientService().execute(requestOne);
        getDishIngredientService().execute(requestTwo);

        SearchIngredientRequest requestThree = new SearchIngredientRequest("Tomato");
        SearchIngredientResponse response = getSearchIngredientService().execute(requestThree);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(0).getQuantity(), 1.0, 0.0001);
        assertEquals(response.getIngredients().get(1).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(1).getQuantity(), 2.0, 0.0001);
    }

    @Test
    public void searchIngredientsOrderAscending() {
        AddDishIngredientRequest requestOne = new AddDishIngredientRequest("Tomato", 2.0 );
        AddDishIngredientRequest requestTwo = new AddDishIngredientRequest("Tomato", 1.0 );
        AddDishIngredientRequest requestThree = new AddDishIngredientRequest("Tomato", 3.0 );
        getDishIngredientService().execute(requestOne);
        getDishIngredientService().execute(requestTwo);
        getDishIngredientService().execute(requestThree);

        Ordering ordering = new Ordering("Q", "A");
        SearchIngredientRequest requestFour = new SearchIngredientRequest("Tomato", ordering, null );
        SearchIngredientResponse response = getSearchIngredientService().execute(requestFour);

        assertEquals(response.getIngredients().size(), 3);
        assertEquals(response.getIngredients().get(0).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(0).getQuantity(), 1.0, 0.0001);
        assertEquals(response.getIngredients().get(1).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(1).getQuantity(), 2.0, 0.0001);
        assertEquals(response.getIngredients().get(2).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(2).getQuantity(), 3.0, 0.0001);

    }

    @Test
    public void searchIngredientsOrderingAndPaging() {
        AddDishIngredientRequest requestOne = new AddDishIngredientRequest("Tomato", 2.0 );
        AddDishIngredientRequest requestTwo = new AddDishIngredientRequest("Tomato", 1.0 );
        AddDishIngredientRequest requestThree = new AddDishIngredientRequest("Tomato", 3.0 );
        getDishIngredientService().execute(requestOne);
        getDishIngredientService().execute(requestTwo);
        getDishIngredientService().execute(requestThree);

        Ordering ordering = new Ordering("Q", "D");
        Paging paging = new Paging(1, 1);
        SearchIngredientRequest requestFour = new SearchIngredientRequest("Tomato", ordering, paging);
        SearchIngredientResponse response = getSearchIngredientService().execute(requestFour);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getIngredient(), "Tomato");
        assertEquals(response.getIngredients().get(0).getQuantity(), 3.0, 0.0001);

    }


}
