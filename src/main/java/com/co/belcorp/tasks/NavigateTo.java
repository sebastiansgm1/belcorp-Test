package com.co.belcorp.tasks;

import static com.co.belcorp.components.HomePage.PE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.relativeUrl(PE));
  }

  public static Performable esikaHomePage() {
    return Tasks.instrumented(NavigateTo.class);
  }

}
