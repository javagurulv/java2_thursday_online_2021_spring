package lv.javaguru.java2.wasterestarant.core.requests;

public class SearchProductRequest {

    private String nameToSearch;

    public SearchProductRequest(String nameToSearch) {
        this.nameToSearch = nameToSearch;
    }

    public String getNameToSearch() {
        return nameToSearch;
    }

    public boolean isNameProvided() {
        return this.nameToSearch != null && !this.nameToSearch.isEmpty();
    }
}
