package lv.javaguru.java2.wasterestarant.core.requests.dish;
// AndrejsB
public class RemoveDishRequest {

    private String name;

    public RemoveDishRequest(String name) {
        this.name = name;
    }

    public RemoveDishRequest() {
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
