package com.co.belcorp.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage extends PageObject {

  public void openPage(String url) {
    getDriver().get(url);
  }

  private static final String SCROLL_INSTRUCTION = "window.scrollBy(0, document.body.scrollHeight)";

  public void scrollDown() {
    JavascriptExecutor executor = (JavascriptExecutor) this.getDriver();
    executor.executeScript(
        SCROLL_INSTRUCTION, "");
  }

  public void scrollToElement(WebElement element) {
    new Actions(getDriver()).moveToElement(element).perform();
  }

  protected void moveToElement(WebElement element) {
    Actions actionProvider = new Actions(getDriver());
    actionProvider.moveToElement(element).build().perform();
    ;
  }
}
