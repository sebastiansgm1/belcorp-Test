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

  @FindBy(id = "guest.confirm.email")
  private WebElementFacade txtConfirmEmail;

  @FindBy(name = "agreeToReceivePublicity")
  private WebElementFacade chkAcceptTerms;

  @FindBy(css = "button.btn.btn-magenta.btn-block.guestCheckoutBtn")
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

  public void setConfirmEmail(String confirmEmail) {
    typeInto(txtConfirmEmail, confirmEmail);
  }

  public void acceptTerms() {
    chkAcceptTerms.click();
  }

  public void loginAsGuest(){
    btnLoginAsGuest.click();
  }

}
