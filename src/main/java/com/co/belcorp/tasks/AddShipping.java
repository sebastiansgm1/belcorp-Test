package com.co.belcorp.tasks;

import static com.co.belcorp.components.CheckOut.BTN_ADDRESS_SUBMIT;
import static com.co.belcorp.components.CheckOut.CMB_DEPARTMENT;
import static com.co.belcorp.components.CheckOut.CMB_DISTRICT;
import static com.co.belcorp.components.CheckOut.CMB_PROVINCE;
import static com.co.belcorp.components.CheckOut.TXT_ADDRESS;
import static com.co.belcorp.components.CheckOut.TXT_ADITIONAL_INFO;
import static com.co.belcorp.components.CheckOut.TXT_PHONE_NUMBER;
import static com.co.belcorp.components.CheckOut.TXT_REFERENCE;

import com.co.belcorp.models.Address;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

public class AddShipping implements Task {

  private Address address;

  public AddShipping(Address address) {
    this.address = address;
  }

  @Override
  @Step("{0} Add shipping address ")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(SelectFromOptions.byVisibleText(address.getDepartment()).from(CMB_DEPARTMENT),
        SelectFromOptions.byVisibleText(address.getProvince()).from(CMB_PROVINCE),
        SelectFromOptions.byVisibleText(address.getDistrict()).from(CMB_DISTRICT),
        SendKeys.of(address.getAddress()).into(TXT_ADDRESS),
        SendKeys.of(address.getAdditionalInfo()).into(TXT_ADITIONAL_INFO),
        SendKeys.of(address.getReference()).into(TXT_REFERENCE),
        SendKeys.of(address.getPhoneNumber()).into(TXT_PHONE_NUMBER),
        Click.on(BTN_ADDRESS_SUBMIT));
  }

  public static AddShipping address(Address address) {
    return Tasks.instrumented(AddShipping.class, address);
  }
}
