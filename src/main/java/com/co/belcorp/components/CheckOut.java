package com.co.belcorp.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckOut {

  public static final Target CMB_DEPARTMENT =
      Target.the("department list").located(By.id("address.regionIsoParent2"));

  public static final Target CMB_PROVINCE =
      Target.the("Province list").located(By.id("address.regionIsoParent1"));

  public static final Target CMB_DISTRICT =
      Target.the("District list").located(By.id("address.regionIso"));

  public static final Target TXT_ADDRESS =
      Target.the("Address text field").located(By.id("address.line1"));

  public static final Target TXT_ADITIONAL_INFO =
      Target.the("Aditional info text field").located(By.id("address.line2"));

  public static final Target TXT_REFERENCE =
      Target.the("Reference field").located(By.id("address.referencia"));

  public static final Target TXT_PHONE_NUMBER =
      Target.the("Phone number text field").located(By.id("address.phone"));

  public static final Target BTN_ADDRESS_SUBMIT =
      Target.the("submit address button").located(By.id("addressSubmit"));
}
