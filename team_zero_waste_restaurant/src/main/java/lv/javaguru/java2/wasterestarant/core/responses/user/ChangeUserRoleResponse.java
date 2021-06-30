package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class ChangeUserRoleResponse extends CoreResponse {
    private boolean isUserRoleChanged;

    public ChangeUserRoleResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeUserRoleResponse(boolean isUserRoleChanged) {
        this.isUserRoleChanged = isUserRoleChanged;
    }

    public ChangeUserRoleResponse() {
    }

    public boolean isUserRoleChanged() {
        return isUserRoleChanged;
    }
}
