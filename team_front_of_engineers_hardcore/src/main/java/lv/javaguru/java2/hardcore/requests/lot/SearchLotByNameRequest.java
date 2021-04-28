package lv.javaguru.java2.hardcore.requests.lot;

public class SearchLotByNameRequest {

    private String name;

    public SearchLotByNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }
}
