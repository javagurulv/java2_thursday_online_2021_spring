package lv.javaguru.java2.hardcore.core.response.lot;

import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class RemoveLotResponse extends CoreResponse {

    private boolean isRemoved;

    public RemoveLotResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveLotResponse(boolean isRemoved) {

        this.isRemoved = isRemoved;
    }

    public boolean isRemoved() {
        return isRemoved;
    }


}
