package lv.javaguru.java2.wasterestarant.services;

import lv.javaguru.java2.wasterestarant.database.Database;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public class AddDishService {

    private Database database;

    public AddDishService(Database database) {
        this.database = database;
    }

    public void execute(String dishName, String dishDescription, String dishType,
                        double dishWeight, double dishPrice, List<Product> productList) {
        Dish dish = new Dish(dishName, dishDescription, dishType, dishWeight, dishPrice, productList);
        database.save(dish);
    }

}
