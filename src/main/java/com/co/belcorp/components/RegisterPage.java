package com.co.belcorp.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {

  public static final Target TXT_NAME =
      Target.the("Name text field").located(By.id("guest.firstName"));

  public static final Target TXT_LAST_NAME =
      Target.the("Last Name text field").located(By.id("guest.lastName"));

  public static final Target TXT_EMAIL =
      Target.the("Email text field").located(By.id("guest.email"));

  public static final Target TXT_CONFIRM_EMAIL =
      Target.the("Confirm Email text field").located(By.id("guest.confirm.email"));

  public static final Target CHK_ACCEPT_TERMS =
      Target.the("Accept terms checkbox").located(By.name("agreeToReceivePublicity"));

  public static final Target BTN_LOGIS_AS_GUEST =
      Target.the("Login button")
          .located(By.cssSelector("button.btn.btn-magenta.btn-block.guestCheckoutBtn"));

  public static final Target BTN_GO_PAY =
      Target.the("go pay button").located(By.cssSelector("a.btn.btn-black"));

}
