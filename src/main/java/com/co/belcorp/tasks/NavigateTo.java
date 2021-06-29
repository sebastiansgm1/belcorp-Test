package com.co.belcorp.tasks;

import com.co.belcorp.components.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable esikaHomePage() {
        return Task.where("{0} opens esika home page", Open.browserOn().the(HomePage.class));
    }
}
