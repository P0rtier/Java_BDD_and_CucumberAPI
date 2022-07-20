package com.pluralsight.bdd.smoothieTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SmoothieStepDefiniton {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema(drinkCatalog);

    private MorningFreshnessMember michael;
    @Given("the following drink categoies:")
    public void the_following_drink_categoies(List<Map<String, String>> drinkCategory) {
        drinkCategory.stream().forEach(
                t -> {
                    String drink = t.get("Drink");
                    String category = t.get("Category");
                    Integer points = Integer.parseInt(t.get("Points"));
                    drinkCatalog.addDrink(drink, category);
                    superSmoothieSchema.setPointsPerCategory(category,points);
                }
        );
    }

    @Given("^(.*) is a mornign Freshness Memeber$")
    public void michael_is_a_mornign_Freshness_Memeber(String name) {
        michael = new MorningFreshnessMember(name,superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?$")
    public void michael_purchases_Banana_drinks(String name,
                                                Integer amount,
                                                String drink) {
        michael.getByName(name).orders(amount,drink);
        //michael.orders(amount,drink);
    }

    @Then("^s?he should earn (\\d+) points$")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(michael.getPoints()).isEqualTo(expectedPoints);
    }
}
