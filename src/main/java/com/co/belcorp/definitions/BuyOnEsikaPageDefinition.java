package com.co.belcorp.definitions;

import com.co.belcorp.steps.AddAddressStep;
import com.co.belcorp.steps.BuyOnEsikaStep;
import com.co.belcorp.steps.RegisterStep;
import com.co.belcorp.utilities.CsvUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class BuyOnEsikaPageDefinition {

  @Steps
  BuyOnEsikaStep buyOnEsikaStep;

  @Steps
  RegisterStep registerStep;

  @Steps
  AddAddressStep addAddressStep;

  @Given("I entered the page {string} and entered {string} section")
  public void enterPageAndSection(String page, String section) {
    buyOnEsikaStep.enterPageAndSection(page, section);
  }

  @When("I add the {string} product with {int} additional quanity")
  public void addProductWithAdditionalQuanity(String product, Integer quantity) {
    buyOnEsikaStep.addProductWithAdditionalQuanity(product, quantity);
  }

  @When("I register as a guest with the following information")
  public void registerGuest(DataTable registrationInformation) {
    registerStep.registerGuest(registrationInformation.asMaps().get(0));
  }

  @When("add the shipping address {string}")
  public void addShippingAddress(String addressFilter) throws IOException {
    addAddressStep.addShippingAddress(CsvUtilities.getMapTestData("register", addressFilter));
  }

  @Then("shipping address will be registered")
  public void verifyAddressRegistered() {
    addAddressStep.verifyAddressRegistered();
  }
}
