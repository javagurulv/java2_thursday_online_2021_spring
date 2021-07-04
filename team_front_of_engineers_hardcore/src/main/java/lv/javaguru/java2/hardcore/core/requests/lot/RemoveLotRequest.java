package lv.javaguru.java2.hardcore.core.requests.lot;

public class RemoveLotRequest {

    private Long id;

    public RemoveLotRequest() {
    }

    public RemoveLotRequest(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
