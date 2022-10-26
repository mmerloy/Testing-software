package ru.miet.testing;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySteps {
    Main app;

    @Given("^I have entered first number ([0-9.,-]+) into the calculator$")
    public void enterFirst(double double1) {
        app = new Main();
        app.setVisible(true);
        app.inputA.setText(Double.toString(double1));
    }

    @And ("I have entered second number {double} into the calculator")
    public void enterSecond(double arg2) {
        app.inputB.setText(Double.toString(arg2));
        //throw new io.cucumber.java.PendingException();
    }
    @When("I press plus")
    public void pressPlus() {
        app.plus.doClick();
    }

    @When("I press minus")
    public void pressMinus() {
        app.minus.doClick();
    }

    @When("I press multiply")
    public void pressMultiply() {
        app.multiply.doClick();
    }

    @When("I press divide")
    public void pressDivide() {
        app.divide.doClick();
    }

    @Then("the result should be {double} on the screen")
    public void result(double arg12){
        Assertions.assertEquals(Double.toString(arg12), app.output.getText());
    }
}
