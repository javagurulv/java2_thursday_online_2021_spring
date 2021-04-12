package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.Offer;

import java.util.List;

public class GetAllOffersService {
    Database database;

    public GetAllOffersService(Database database) {
        this.database = database;
    }

    public List<Offer> execute(){
        return database.getAllOffers();
    }
}
