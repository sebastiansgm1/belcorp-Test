package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCardPage extends GeneralPage {

  @FindBy(css = "button.btn.js-qty-selector-plus")
  private WebElementFacade btnAddQuantity;

  @FindBy(id = "addToCartButton")
  private WebElementFacade btnAddProduct;

  @FindBy(css = "a.btn.btn-black.btn-block.add-to-cart-button")
  private WebElementFacade btnCart;

  public void addQuantity(int quantity) {
    for (int i = 0; i < quantity; i++) {
      btnAddQuantity.click();
      new WebDriverWait(getDriver(), 1);
    }
  }

  public void addProduct(){
    btnAddProduct.click();
  }

  public void goCart(){
    btnCart.click();
  }

}
