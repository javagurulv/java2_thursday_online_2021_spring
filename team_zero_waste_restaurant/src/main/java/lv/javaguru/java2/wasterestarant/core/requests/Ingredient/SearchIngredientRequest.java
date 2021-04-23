package lv.javaguru.java2.wasterestarant.core.requests.Ingredient;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;

public class SearchIngredientRequest {

    private String ingredientName;
    private Ordering ordering;
    private Paging paging;


    public SearchIngredientRequest(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public SearchIngredientRequest(String ingredientName, Ordering ordering) {
        this.ingredientName = ingredientName;
        this.ordering = ordering;
    }

    public SearchIngredientRequest(String ingredientName, Paging paging) {
        this.ingredientName = ingredientName;
        this.paging = paging;
    }

    public SearchIngredientRequest(String ingredientName, Ordering ordering, Paging paging) {
        this.ingredientName = ingredientName;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public boolean isIngredientNameProvided(){
        return this.ingredientName != null && !this.ingredientName.isEmpty();
    }

}
