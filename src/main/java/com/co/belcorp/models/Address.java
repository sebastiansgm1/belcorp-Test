package com.co.belcorp.models;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String department;
  private String province;
  private String district;
  private String address;
  private String additionalInfo;
  private String reference;
  private String phoneNumber;

  public static Address getAddress(Map<String, String> dataAddress) {
    return new AddressBuilder().department(dataAddress.get("Department"))
        .province(dataAddress.get("Province")).district(dataAddress.get("District"))
        .address(dataAddress.get("Address"))
        .additionalInfo(dataAddress.get("Additional Info")).reference(dataAddress.get("Reference"))
        .phoneNumber(dataAddress.get("PhoneNumber")).build();
  }

}
