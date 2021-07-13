package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class UpdateUserRoleResponse extends CoreResponse {

    private boolean update;

    public UpdateUserRoleResponse(boolean update) {
        this.update = update;
    }

    public UpdateUserRoleResponse(List<CoreError> errors) {
        super(errors);
    }

    public Boolean getUpdate() {
        return update;
    }
}
