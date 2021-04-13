package com.co.belcorp.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.By;

public class CheckOut extends GeneralPage {

  @FindBy(id = "address.regionIsoParent2")
  private WebElementFacade cmbDepartment;

  @FindBy(id = "address.regionIsoParent1")
  private WebElementFacade cmbProvince;

  @FindBy(id = "address.regionIso")
  private WebElementFacade cmbDistrict;

  @FindBy(id = "address.line1")
  private WebElementFacade txtAddress;

  @FindBy(id = "address.line2")
  private WebElementFacade txtAditionalInfo;

  @FindBy(id = "address.referencia")
  private WebElementFacade txtReference;

  @FindBy(id = "address.phone")
  private WebElementFacade txtPhoneNumber;

  @FindBy(id = "addressSubmit")
  private WebElementFacade btnAddressSubmit;

  public void setDepartment(String department) {
    cmbDepartment.selectByVisibleText(department);
  }

  public void setProvince(String province) {
    cmbProvince.selectByVisibleText(province);
  }

  public void setDistrict(String district) {
    cmbDistrict.selectByVisibleText(district);
  }

  public void setAddress(String address) {
    typeInto(txtAddress, address);
  }

  public void setAditionalInfo(String aditionalInfo) {
    typeInto(txtAditionalInfo, aditionalInfo);
  }

  public void setReference(String reference) {
    typeInto(txtReference, reference);
  }

  public void setPhoneNumber(String phoneNumber) {
    typeInto(txtPhoneNumber, phoneNumber);
  }

  public void addressSubmit() {
    btnAddressSubmit.click();
  }

  public boolean verifyAddress(String address) {
    return find(By.xpath(String
        .format("//div[@class='checkout-shipping-items row']//span[contains(text(), '%s')]",
            address))).isVisible();
  }
}
