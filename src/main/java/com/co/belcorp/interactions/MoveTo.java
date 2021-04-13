package com.co.belcorp.interactions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveTo implements Interaction {

  private String locator;

  public MoveTo(String locator) {
    this.locator = locator;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebElement element = getDriver().findElement(By.xpath(locator));
    Actions actionProvider = new Actions(getDriver());
    actionProvider.moveToElement(element).build().perform();
  }

  public static MoveTo element(String locator) {
    return Tasks.instrumented(MoveTo.class, locator);
  }

}
