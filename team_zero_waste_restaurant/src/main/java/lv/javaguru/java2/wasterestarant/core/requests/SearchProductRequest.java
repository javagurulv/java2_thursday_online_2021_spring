package lv.javaguru.java2.wasterestarant.core.requests;
//AndrejsB
public class SearchProductRequest {

    private String nameToSearch;

    private Ordering ordering;

    public SearchProductRequest(String nameToSearch) {
        this.nameToSearch = nameToSearch;
    }


    public SearchProductRequest(String nameToSearch, Ordering ordering) {
        this.nameToSearch = nameToSearch;
        this.ordering = ordering;
    }

    public String getNameToSearch() {
        return nameToSearch;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public boolean isNameProvided() {
        return this.nameToSearch != null && !this.nameToSearch.isEmpty();
    }
}
