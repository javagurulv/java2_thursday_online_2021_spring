package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class Ordering {

    private final String orderBy;
    private final String orderDirection;

    public Ordering(String orderBy, String orderDirection) {
        this.orderBy = orderBy;
        this.orderDirection = orderDirection;
    }
}
