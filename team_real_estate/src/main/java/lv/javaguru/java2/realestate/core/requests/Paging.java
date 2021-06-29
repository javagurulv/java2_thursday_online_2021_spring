package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class Paging {

    private final Integer pageNumber;
    private final Integer pageSize;

    public Paging(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
