package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends GeneralPage {

  @FindBy(id = "guest.firstName")
  private WebElementFacade txtName;

  @FindBy(id = "guest.lastName")
  private WebElementFacade txtLastName;

  @FindBy(id = "guest.email")
  private WebElementFacade txtEmail;

  @FindBy(xpath = "//input[@name = 'belcorpToC'][@id = 'guest.belcorpToC']")
  private WebElementFacade chkAccept;

  @FindBy(xpath = "//form[@id = 'guestForm']//button")
  private WebElementFacade btnLoginAsGuest;

  public void setName(String name) {
    typeInto(txtName, name);
  }

  public void setLastName(String lastName) {
    typeInto(txtLastName, lastName);
  }

  public void setEmail(String email) {
    typeInto(txtEmail, email);
  }

  public void acceptTerms() {
    $("[id = 'guest.belcorpToC']").click(); //This is the other notation option for find element
  }

  public void loginAsGuest(){
    btnLoginAsGuest.click();
  }

}
