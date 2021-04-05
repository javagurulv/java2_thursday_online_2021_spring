package services;

import database.Database;
import database.InMemoryDatabaseImpl;
import domain.Offer;

public class DeleteOfferService {
    Database database = new InMemoryDatabaseImpl();

    public void execute(String offerType, String propertyCategory, String description, double price){
        database.deleteOffer(new Offer(offerType, propertyCategory, description, price));
    }
}
