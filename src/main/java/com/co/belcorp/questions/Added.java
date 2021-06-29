package com.co.belcorp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class Added implements Question<Boolean> {

    private String address;

    public Added(String address) {
        this.address = address;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(String
                .format("//div[@class='checkout-shipping-items row']//span[contains(text(), '%s')]",
                        address)).viewedBy(actor).asBoolean();
    }


    public static Added address(String address) {
        return new Added(address);
    }

}
