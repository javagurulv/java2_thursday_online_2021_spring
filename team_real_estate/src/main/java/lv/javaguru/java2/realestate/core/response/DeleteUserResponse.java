package lv.javaguru.java2.realestate.core.response;

import java.util.List;

public class DeleteUserResponse extends CoreResponse {
    private boolean isUserDeleted;

    public DeleteUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteUserResponse(boolean isUserDeleted) {
        this.isUserDeleted = isUserDeleted;
    }

    public boolean isUserDeleted() {
        return isUserDeleted;
    }
}
