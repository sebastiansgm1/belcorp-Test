package com.co.belcorp.tasks;

import com.co.belcorp.interactions.MoveTo;
import java.util.Arrays;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class NavigatesTo implements Task {

  private String section;

  public NavigatesTo(String section) {
    this.section = section;
  }

  @Override
  @Step("{0} Open section ")
  public <T extends Actor> void performAs(T actor) {
    List<String> sections = Arrays.asList(section.split("/"));
    actor.attemptsTo(
        MoveTo.element(String.format("//a[@title='%s']", sections.get(0))),
        Click.on(By.xpath(String.format("//a[@title='%s']", sections.get(1)))));
  }

  public static NavigatesTo theSection(String section) {
    return Tasks.instrumented(NavigatesTo.class, section);
  }
}
