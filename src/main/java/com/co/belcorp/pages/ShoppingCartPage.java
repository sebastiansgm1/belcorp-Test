package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPage extends GeneralPage{

  @FindBy(xpath = "//div[@class = 'actions']/button[@id='checkout-display-continueCheckout']")
  private WebElementFacade btnGoCheckOut;

  public void goCheckOut(){
    btnGoCheckOut.waitUntilVisible().click();
  }

}
