package com.pluralsight.bdd.smoothieTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com/pluralsight/bdd/features/loyality_features",
            glue = "com.pluralsight.bdd"
)
public class SmothieTest {
}
