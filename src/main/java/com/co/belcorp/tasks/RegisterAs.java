package com.co.belcorp.tasks;

import static com.co.belcorp.components.RegisterPage.BTN_GO_PAY;
import static com.co.belcorp.components.RegisterPage.BTN_LOGIS_AS_GUEST;
import static com.co.belcorp.components.RegisterPage.CHK_ACCEPT_TERMS;
import static com.co.belcorp.components.RegisterPage.TXT_CONFIRM_EMAIL;
import static com.co.belcorp.components.RegisterPage.TXT_EMAIL;
import static com.co.belcorp.components.RegisterPage.TXT_LAST_NAME;
import static com.co.belcorp.components.RegisterPage.TXT_NAME;

import com.co.belcorp.models.Guest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

public class RegisterAs implements Task {

  private Guest guest;

  public RegisterAs(Guest guest) {
    this.guest = guest;
  }

  @Override
  @Step("{0} Register Guest ")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(SendKeys.of(guest.getName()).into(TXT_NAME),
        SendKeys.of(guest.getLastName()).into(TXT_LAST_NAME),
        SendKeys.of(guest.getEmail()).into(TXT_EMAIL),
        SendKeys.of(guest.getEmail()).into(TXT_CONFIRM_EMAIL),
        Click.on(CHK_ACCEPT_TERMS), Click.on(BTN_LOGIS_AS_GUEST));
  }

  public static RegisterAs aGuest(Guest guest) {
    return Tasks.instrumented(RegisterAs.class, guest);
  }
}
