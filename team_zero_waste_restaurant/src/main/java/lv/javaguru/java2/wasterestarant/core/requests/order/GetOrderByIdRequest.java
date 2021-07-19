package lv.javaguru.java2.wasterestarant.core.requests.order;

public class GetOrderByIdRequest {

    private Long id;

    public GetOrderByIdRequest() { }

    public GetOrderByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
