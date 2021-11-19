package com.co.belcorp.pages;

import java.util.Arrays;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/pe")
public class EsikaHomePage extends GeneralPage {

  public void openSection(String section) {
    List<String> sections = Arrays.asList(section.split("/"));
    moveToElement(
        getDriver().findElement(By.xpath(String.format("//a[@title='%s']", sections.get(0)))));
    find(By.xpath(String.format("//a[@title='%s']", sections.get(1)))).click();
  }
}
