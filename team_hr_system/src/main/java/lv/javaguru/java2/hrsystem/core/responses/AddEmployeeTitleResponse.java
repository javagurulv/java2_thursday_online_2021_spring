package lv.javaguru.java2.hrsystem.core.responses;

import java.util.List;

public class AddEmployeeTitleResponse extends CoreResponse{
    private boolean titleAdded;

    public AddEmployeeTitleResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddEmployeeTitleResponse(boolean titleAdded) {
        this.titleAdded = titleAdded;
    }

    public boolean isTitleAdded() {
        return titleAdded;
    }

    public void setTitleAdded(boolean titleAdded) {
        this.titleAdded = titleAdded;
    }
}