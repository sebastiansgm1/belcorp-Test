package com.co.belcorp.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = "src/test/resources/features/buy_on_the_esika_page.feature",
    glue = {"com.co.belcorp.stepdefinitions",
        "com.co.belcorp.hooks"})

public class BuyEsikaRunner {

}
