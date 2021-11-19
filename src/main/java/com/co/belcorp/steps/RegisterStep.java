package com.co.belcorp.steps;

import static com.co.belcorp.models.Guest.getGuest;

import com.co.belcorp.models.Guest;
import com.co.belcorp.pages.RegisterPage;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class RegisterStep {

  @Page
  RegisterPage registerPage;

  @Step
  public void registerGuest(Map<String, String> registerInformation) {
    Guest guest = getGuest(registerInformation);
    registerPage.setName(guest.getName());
    registerPage.setLastName(guest.getLastName());
    registerPage.setEmail(guest.getEmail());
    registerPage.acceptTerms();
    registerPage.loginAsGuest();
  }
}
