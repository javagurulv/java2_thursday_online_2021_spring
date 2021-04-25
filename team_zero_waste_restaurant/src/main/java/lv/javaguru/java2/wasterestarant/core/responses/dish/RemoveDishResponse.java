package lv.javaguru.java2.wasterestarant.core.responses.dish;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;
// AndrejsB

public class RemoveDishResponse extends CoreResponse {

    private boolean dishNameToDelete;

    public RemoveDishResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isDishNameDeleted() {
        return dishNameToDelete;
    }

    public RemoveDishResponse(boolean dishNameToDelete) {
        this.dishNameToDelete = dishNameToDelete;
    }
}
