package com.co.belcorp.stepdefinitions;

import static com.co.belcorp.models.Address.getAddress;
import static com.co.belcorp.models.Guest.getGuest;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

import com.co.belcorp.models.Address;
import com.co.belcorp.models.Guest;
import com.co.belcorp.questions.Added;
import com.co.belcorp.tasks.Add;
import com.co.belcorp.tasks.AddShipping;
import com.co.belcorp.tasks.NavigatesTo;
import com.co.belcorp.tasks.OpenWeb;
import com.co.belcorp.tasks.RegisterAs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class BuyOnEsikaPageDefinition {

  private Address address;
  private Guest guest;

  @Before
  public void prepareStage() {
    setTheStage(new OnlineCast());
  }

  @Given("{string} enters the page {string} and enters {string} section")
  public void enterPageAndSection(String actorName, String page, String section) {
    theActorCalled(actorName).wasAbleTo(OpenWeb.page(page), NavigatesTo.theSection(section));
  }

  @When("He adds the {string} product with {int} additional quanity")
  public void addProductWithAdditionalQuanity(String product, Integer quantity) {
    theActorInTheSpotlight().attemptsTo(Add.product(product, quantity));
  }

  @When("he registers as a guest with the following information")
  public void registerGuest(DataTable registrationInformation) {
    guest = getGuest(registrationInformation.asMaps().get(0));
    theActorInTheSpotlight().attemptsTo(RegisterAs.aGuest(guest));
  }

  @When("adds the shipping address")
  public void addShippingAddress(DataTable addressInformation) {
    address = getAddress(addressInformation.asMaps().get(0));
    theActorInTheSpotlight().attemptsTo(AddShipping.address(address));
  }

  @Then("shipping address is registered")
  public void verifyAddressRegistered() {
    theActorInTheSpotlight().should(seeThat(Added.address(address.getAddress()), is(true)));
  }
}
