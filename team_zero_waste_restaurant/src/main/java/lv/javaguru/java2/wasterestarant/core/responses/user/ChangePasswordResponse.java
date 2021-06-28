package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class ChangePasswordResponse extends CoreResponse {
    private boolean isPasswordChanged;

    public ChangePasswordResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangePasswordResponse(boolean isPasswordChanged) {
        this.isPasswordChanged = isPasswordChanged;
    }

    public boolean isPasswordChanged() {
        return isPasswordChanged;
    }
}
