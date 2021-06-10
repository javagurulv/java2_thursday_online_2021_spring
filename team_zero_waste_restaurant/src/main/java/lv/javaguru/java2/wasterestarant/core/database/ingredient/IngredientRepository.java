package lv.javaguru.java2.wasterestarant.core.database.ingredient;

import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;

import java.util.List;
//AndrejsB
public interface IngredientRepository {

    void save(Ingredient ingredient);

    List<Ingredient> findIngredientByName(String name);
}
