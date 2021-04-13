package com.co.belcorp.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductCard {

  public static final Target BTN_ADD_QUANTITY =
      Target.the("Add quantity button").located(By.cssSelector("button.btn.js-qty-selector-plus"));

  public static final Target BTN_ADD_PRODUCT =
      Target.the("Add product button").located(By.id("addToCartButton"));

  public static final Target BTN_CART =
      Target.the("go cart button").located(By.cssSelector("a.btn.btn-black.btn-block.add-to-cart-button"));
}
