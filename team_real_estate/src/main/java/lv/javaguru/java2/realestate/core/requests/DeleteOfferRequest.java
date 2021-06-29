package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class DeleteOfferRequest {
    private final Integer id;

    public DeleteOfferRequest(Integer id) {
        this.id = id;
    }

}
