package com.co.belcorp.steps;

import static com.co.belcorp.models.Address.getAddress;
import static com.co.belcorp.utilities.AssertionMessages.ERROR_ADD_ADDRESS;
import static org.assertj.core.api.Assertions.assertThat;

import com.co.belcorp.models.Address;
import com.co.belcorp.pages.CheckOut;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AddAddressStep {

  @Page
  CheckOut checkOut;

  private Address address;

  @Step
  public void addShippingAddress(Map<String, String> stringStringMap) {
    address = getAddress(stringStringMap);
    checkOut.setDepartment(address.getDepartment());
    checkOut.setProvince(address.getProvince());
    checkOut.setDistrict(address.getDistrict());
    checkOut.setAddress(address.getAddress());
    checkOut.setAditionalInfo(address.getAdditionalInfo());
    checkOut.setReference(address.getReference());
    checkOut.setPhoneNumber(address.getPhoneNumber());
    checkOut.addressSubmit();
  }

  @Step
  public void verifyAddressRegistered(){
    assertThat(checkOut.verifyAddress()).contains(address.getAddress());
  }
}
