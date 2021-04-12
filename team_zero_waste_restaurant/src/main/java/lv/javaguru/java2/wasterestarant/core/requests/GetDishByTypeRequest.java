package lv.javaguru.java2.wasterestarant.core.requests;

public class GetDishByTypeRequest {

    private String dishType;

    public String getDishType() {
        return dishType;
    }

    public GetDishByTypeRequest(String dishType) {
        this.dishType = dishType;
    }
}
