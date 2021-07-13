package lv.javaguru.java2.realestate.controller;

import lombok.Getter;
import lv.javaguru.java2.realestate.core.response.CoreError;

import java.util.List;

@Getter
public class ResponseErrors extends Exception{
    private List<CoreError> errors;

    public ResponseErrors(List<CoreError> errors) {
        this.errors = errors;
    }
}
