package com.co.belcorp.steps;

import com.co.belcorp.pages.EsikaHomePage;
import com.co.belcorp.pages.GeneralPage;
import com.co.belcorp.pages.ProductCardPage;
import com.co.belcorp.pages.SectionPage;
import com.co.belcorp.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BuyOnEsikaStep {

  @Page
  GeneralPage generalPage;

  @Page
  EsikaHomePage esikaHomePage;

  @Page
  SectionPage sectionPage;

  @Page
  ProductCardPage productCardPage;

  @Page
  ShoppingCartPage shoppingCartPage;

  @Step
  public void enterPageAndSection(String page, String section) {
    generalPage.openPage(page);
    esikaHomePage.openSection(section);
  }

  @Step
  public void addProductWithAdditionalQuanity(String product, Integer quantity){
    sectionPage.openProduct(product);
    productCardPage.addQuantity(quantity);
    productCardPage.addProduct();
    productCardPage.goCart();
    shoppingCartPage.goCheckOut();
  }
}
