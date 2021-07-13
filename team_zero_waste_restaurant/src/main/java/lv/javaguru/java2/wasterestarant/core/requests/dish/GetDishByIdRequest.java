package lv.javaguru.java2.wasterestarant.core.requests.dish;



public class GetDishByIdRequest {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GetDishByIdRequest(Long id) {
        this.id = id;
    }

    public GetDishByIdRequest() {
    }
}
