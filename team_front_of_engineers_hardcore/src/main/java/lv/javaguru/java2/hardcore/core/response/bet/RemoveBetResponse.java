package lv.javaguru.java2.hardcore.core.response.bet;

import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class RemoveBetResponse extends CoreResponse {

    private boolean isRemoved;

    public RemoveBetResponse(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public RemoveBetResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
