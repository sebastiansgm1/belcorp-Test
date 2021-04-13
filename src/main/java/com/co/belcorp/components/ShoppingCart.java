package com.co.belcorp.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCart {

  public static final Target BTN_GO_CHECK_OUT =
      Target.the("go check out button").located(By.xpath("//div[@id='StickySidebar']//button[contains(text(),'Ir a pagar')]"));

}
