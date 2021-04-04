package services;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.Offer;

import java.util.List;

public class ViewAllOffersService {
    Database database = new InMemoryDatabaseImpl();

    public List<Offer> execute(){
        return database.viewAllOffers();
    }
}
