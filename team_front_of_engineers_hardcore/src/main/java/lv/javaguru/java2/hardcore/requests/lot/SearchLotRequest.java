package lv.javaguru.java2.hardcore.requests.lot;

public class SearchLotRequest {

    private String name;

    public SearchLotRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
