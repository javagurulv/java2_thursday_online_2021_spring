package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.RemoveDishResponse;

public class RemoveDishService {

    private Database database;

    public RemoveDishService(Database database) {
        this.database = database;
    }

    public RemoveDishResponse execute(RemoveDishRequest request) {
        boolean isDishDeleted = database.deleteByNameBool(request.getDishNameToRemove());
        return new RemoveDishResponse(isDishDeleted);
    }
}
