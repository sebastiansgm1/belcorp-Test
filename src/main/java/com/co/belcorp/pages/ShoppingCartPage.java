package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPage extends GeneralPage{

  @FindBy(xpath = "//div[@id='StickySidebar']//button[contains(text(),'Ir a pagar')]")
  private WebElementFacade btnGoCheckOut;

  public void goCheckOut(){
    btnGoCheckOut.waitUntilVisible().click();
  }

}
