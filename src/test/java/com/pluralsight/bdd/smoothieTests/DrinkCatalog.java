package com.pluralsight.bdd.smoothieTests;

import java.util.HashMap;
import java.util.Map;

public class DrinkCatalog {

    Map<String,String> drinkCategories = new HashMap<>();
    public void addDrink(String drink, String category) {
        drinkCategories.put(drink,category);
    }

    public String getCategoryofDrink(String drink) {
        return drinkCategories.get(drink);
    }
}
