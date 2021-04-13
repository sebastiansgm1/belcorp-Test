package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.By;

public class SectionPage extends GeneralPage {

  public void openProduct(String product) {
    find(By.xpath(String.format("//a[@class='name'][contains(text(),'%s')]", product))).click();
  }
}
