package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class DeleteEmployeeResponse extends CoreResponse{
    private boolean removed;

    public DeleteEmployeeResponse(boolean removed) {
        this.removed = removed;
    }

    public DeleteEmployeeResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}