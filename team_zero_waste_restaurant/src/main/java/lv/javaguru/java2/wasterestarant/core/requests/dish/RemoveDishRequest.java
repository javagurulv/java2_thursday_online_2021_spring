package lv.javaguru.java2.wasterestarant.core.requests.dish;
// AndrejsB
public class RemoveDishRequest {

    private String dishNameToRemove;

    public RemoveDishRequest(String dishNameToRemove) {
        this.dishNameToRemove = dishNameToRemove;
    }

    public String getDishNameToRemove() {
        return dishNameToRemove;
    }
}