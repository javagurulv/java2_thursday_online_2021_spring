package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;

@Getter
public class CoreError {

    private final String field;
    private final String message;

    public CoreError(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
