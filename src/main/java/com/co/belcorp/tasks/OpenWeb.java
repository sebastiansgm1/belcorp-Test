package com.co.belcorp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenWeb implements Task {

  private String url;

  public OpenWeb(String url) {
    this.url = url;
  }

  @Override
  @Step("{0} Open esika web page ")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.url(url));
  }

  public static OpenWeb page(String url) {
    return Tasks.instrumented(OpenWeb.class, url);
  }
}
