package lv.javaguru.java2.wasterestarant.core.requests.ingredient;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;

public class SearchIngredientRequest {

    private String ingredientName;
    private Long dishId;
    private Ordering ordering;
    private Paging paging;


    public SearchIngredientRequest(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public SearchIngredientRequest(String ingredientName, Ordering ordering) {
        this.ingredientName = ingredientName;
        this.ordering = ordering;
    }

    public SearchIngredientRequest(String ingredientName, Long dishId, Ordering ordering, Paging paging) {
        this.ingredientName = ingredientName;
        this.dishId = dishId;
        this.ordering = ordering;
        this.paging = paging;
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

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public SearchIngredientRequest() {

    }

    public Long getDishId() {
        return dishId;
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

    public boolean isDishIdProvided(){
        return this.dishId != null;
    }

}
