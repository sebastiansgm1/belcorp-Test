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
public class Guest {

  private String name;
  private String lastName;
  private String email;

  public static Guest getGuest(Map<String, String> dataGuest) {
    return new GuestBuilder().name(dataGuest.get("Name")).lastName(dataGuest.get("LastName"))
        .email(dataGuest.get("Email")).build();
  }
}
