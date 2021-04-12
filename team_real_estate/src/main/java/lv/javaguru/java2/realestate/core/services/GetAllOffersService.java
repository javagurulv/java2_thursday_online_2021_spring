package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;

public class GetAllOffersService {
    Database database;

    public GetAllOffersService(Database database) {
        this.database = database;
    }

    public GetAllOffersResponse execute(GetAllOffersRequest getAllOffersRequest){
        return new GetAllOffersResponse(database.getAllOffers());
    }
}
