package lv.javaguru.java2.wasterestarant.core.requests.product;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;

//AndrejsB
public class SearchProductRequest {

    private String nameToSearch;

    private Double quantity;

    private Ordering ordering;

    private Paging paging;

    public SearchProductRequest(String nameToSearch) {
        this.nameToSearch = nameToSearch;
    }

    public SearchProductRequest(String nameToSearch, Ordering ordering, Paging paging) {
        this.nameToSearch = nameToSearch;
        this.ordering = ordering;
        this.paging = paging;
    }

    public SearchProductRequest(String nameToSearch, Paging paging) {
        this.nameToSearch = nameToSearch;
        this.paging = paging;
    }

    public SearchProductRequest(String nameToSearch, Ordering ordering) {
        this.nameToSearch = nameToSearch;
        this.ordering = ordering;
    }

    public SearchProductRequest(String nameToSearch, Double quantity, Paging paging) {
        this.nameToSearch = nameToSearch;
        this.quantity = quantity;
        this.paging = paging;
    }

    public SearchProductRequest() {

    }

    public String getNameToSearch() {
        return nameToSearch;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public boolean isNameProvided() {
        return this.nameToSearch != null && !this.nameToSearch.isEmpty();
    }

    public void setNameToSearch(String nameToSearch) {
        this.nameToSearch = nameToSearch;
    }
}
