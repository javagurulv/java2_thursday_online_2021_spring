package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class DeleteUserResponse extends CoreResponse{

    private boolean removed;

    public DeleteUserResponse(boolean removed) {
        this.removed = removed;
    }

    public DeleteUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isRemoved() {
        return removed;
    }
}
