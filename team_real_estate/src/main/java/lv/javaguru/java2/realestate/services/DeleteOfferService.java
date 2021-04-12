package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.domain.Offer;

public class DeleteOfferService {
    Database database;

    public DeleteOfferService(Database database) {
        this.database = database;
    }

    public void execute(String offerType, String propertyCategory, String description, double price){
        database.deleteOffer(new Offer(offerType, propertyCategory, description, price));
    }
}
