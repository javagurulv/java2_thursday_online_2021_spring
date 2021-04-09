package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.Offer;

import java.util.List;

public class ViewAllOffersService {
    Database database = new InMemoryDatabaseImpl();

    public List<Offer> execute(){
        return database.viewAllOffers();
    }
}
