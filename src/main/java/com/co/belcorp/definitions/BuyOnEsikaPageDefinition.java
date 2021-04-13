package com.co.belcorp.definitions;

import com.co.belcorp.steps.AddAddressStep;
import com.co.belcorp.steps.BuyOnEsikaStep;
import com.co.belcorp.steps.RegisterStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BuyOnEsikaPageDefinition {

  @Steps
  BuyOnEsikaStep buyOnEsikaStep;

  @Steps
  RegisterStep registerStep;

  @Steps
  AddAddressStep addAddressStep;

  @Given("I enter the page {string} and enter {string} section")
  public void enterPageAndSection(String page, String section) {
    buyOnEsikaStep.enterPageAndSection(page, section);
  }

  @When("I add the {string} product with {int} additional quanity")
  public void addProductWithAdditionalQuanity(String product, Integer quantity){
    buyOnEsikaStep.addProductWithAdditionalQuanity(product, quantity);
  }

  @When("I register as a guest with the following information")
  public void registerGuest(DataTable registrationInformation){
    registerStep.registerGuest(registrationInformation.asMaps().get(0));
  }

  @When("add the shipping address")
  public void addShippingAddress(DataTable addressInformation) {
    addAddressStep.addShippingAddress(addressInformation.asMaps().get(0));
  }

  @Then("shipping address is registered")
  public void verifyAddressRegistered() {
    addAddressStep.verifyAddressRegistered();
  }
}
