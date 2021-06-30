package lv.javaguru.java2.wasterestarant.core.requests.ingredient;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;

public class SearchIngredientRequest {

    private String name;
    private Long dishIngredientID;
    private Ordering ordering;
    private Paging paging;


    public SearchIngredientRequest(String name) {
        this.name = name;
    }

    public SearchIngredientRequest(String name, Ordering ordering) {
        this.name = name;
        this.ordering = ordering;
    }

    public SearchIngredientRequest(String name, Long dishIngredientID, Ordering ordering, Paging paging) {
        this.name = name;
        this.dishIngredientID = dishIngredientID;
        this.ordering = ordering;
        this.paging = paging;
    }

    public SearchIngredientRequest(String name, Paging paging) {
        this.name = name;
        this.paging = paging;
    }

    public SearchIngredientRequest(String name, Ordering ordering, Paging paging) {
        this.name = name;
        this.ordering = ordering;
        this.paging = paging;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDishIngredientID(Long dishIngredientID) {
        this.dishIngredientID = dishIngredientID;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public SearchIngredientRequest() {

    }

    public Long getDishIngredientID() {
        return dishIngredientID;
    }

    public String getName() {
        return name;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public boolean isIngredientNameProvided(){
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isDishIdProvided(){
        return this.dishIngredientID != null;
    }

}
