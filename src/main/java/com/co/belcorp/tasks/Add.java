package com.co.belcorp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.co.belcorp.components.ProductCard.*;
import static com.co.belcorp.components.ShoppingCart.BTN_GO_CHECK_OUT;

public class Add implements Task {

    private String product;
    private Integer quantity;

    public Add(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    @Step("{0} Add product ")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(String.format("//a[@class='name'][contains(text(),'%s')]", product)));
        for (int i = 0; i < quantity; i++) {
            actor.attemptsTo(Click.on(BTN_ADD_QUANTITY));
        }
        actor.attemptsTo(Click.on(BTN_ADD_PRODUCT), Click.on(BTN_CART), Click.on(BTN_GO_CHECK_OUT));
    }

    public static Add product(String product, Integer quantity) {
        return Tasks.instrumented(Add.class, product, quantity);
    }


}
