package services;

import database.Database;
import domain.Dish;
import domain.Product;

import java.util.List;

public class AddDishService {

    private Database database;

    public AddDishService(Database database) {
        this.database = database;
    }

    public void execute(String dishName, String dishDescription, String dishType, String dishComposition,
                        double dishWeight, double dishPrice) {
        Dish dish = new Dish(dishName, dishDescription, dishType, dishComposition, dishWeight, dishPrice);
        database.save(dish);
    }

}
