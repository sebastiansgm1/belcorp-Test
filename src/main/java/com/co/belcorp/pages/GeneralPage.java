package com.co.belcorp.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage extends PageObject {

    public void openPage(String url) {
//        getDriver().manage().window().setSize(new Dimension(1280, 768));
        getDriver().get(url);
    }

    protected void moveToElement(WebElement element) {
        Actions actionProvider = new Actions(getDriver());
        actionProvider.moveToElement(element).build().perform();
    }
}
