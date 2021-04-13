package lv.javaguru.java2.wasterestarant.core.responses;

public class RemoveDishResponse extends CoreResponse{

    private boolean dishNameToDelete;

    public boolean isDishNameDeleted() {
        return dishNameToDelete;
    }

    public RemoveDishResponse(boolean dishNameToDelete) {
        this.dishNameToDelete = dishNameToDelete;
    }
}
