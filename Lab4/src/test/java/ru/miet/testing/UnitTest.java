package ru.miet.testing;//import org.junit.Test;
//import org.junit.jupiter.api.RepeatedTest;

import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    private final CalculatorMock calculatorMock = new CalculatorMock();
    private final String[] errorMessages = {"Error! Wrong number!", "Error! There is no input!",
            "Error! I can't divide to \"0\"!"};
    private final CalculatorPresenter calculatorPresenter = new MyCalculatorPresenter(calculatorMock);

    @Test
    public void firstArgNullSum(){
        calculatorMock.a = null;
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void secondArgNullSum(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = null;
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void allArgsNullSum(){
        calculatorMock.a = null;
        calculatorMock.b = null;
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void firstArgNullSubtract(){
        calculatorMock.a = null;
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void secondArgNullSubtract(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = null;
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void firstArgNullMultiple(){
        calculatorMock.a = null;
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void secondArgNullMultiple(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = null;
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void firstArgNullDivide(){
        calculatorMock.a = null;
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void secondArgNullDivide(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = null;
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[1], calculatorMock.error);
    }

    @Test
    public void secondArgZeroDivide(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = String.valueOf(Math.random()*10e-8);
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[2], calculatorMock.error);

    }

    @Test
    public void firstArgNotNumbersSum(){
        calculatorMock.a = "abcd";
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void secondArgNotNumbersSum(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = "abcd";
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void firstArgNotNumbersSubtract(){
        calculatorMock.a = "abcd";
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void secondArgNotNumbersSubtract(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = "abcd";
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void firstArgNotNumbersMultiple(){
        calculatorMock.a = "abcd";
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void secondArgNotNumbersMultiple(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = "abcd";
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void firstArgNotNumbersDivide(){
        calculatorMock.a = "abcd";
        calculatorMock.b = String.valueOf(Math.random());
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    @Test
    public void secondArgNotNumbersDivide(){
        calculatorMock.a = String.valueOf(Math.random());
        calculatorMock.b = "abcd";
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[0], calculatorMock.error);
    }

    //@RepeatedTest(10)
    @Test
    public void checkSum(){
        double a = 0.1;
        double b = 0.2;
        calculatorMock.a = String.valueOf(a);
        calculatorMock.b = String.valueOf(b);
        calculatorPresenter.onPlusClicked();
        assertEquals(String.valueOf(a+b), calculatorMock.result);
    }

    @RepeatedTest(10)
    public void checkSubtract(){
        double a = Math.random();
        double b = Math.random();
        calculatorMock.a = String.valueOf(a);
        calculatorMock.b = String.valueOf(b);
        calculatorPresenter.onMinusClicked();
        assertEquals(String.valueOf(a-b), calculatorMock.result);
    }

    @RepeatedTest(10)
    public void checkMultiple(){
        double a = Math.random();
        double b = Math.random();
        calculatorMock.a = String.valueOf(a);
        calculatorMock.b = String.valueOf(b);
        calculatorPresenter.onMultiplyClicked();
        assertEquals(String.valueOf(a*b), calculatorMock.result);
    }

    @RepeatedTest(10)
    void checkDivide(){
        double a = Math.random();
        double b = Math.random();
        while(b==0.0){
            b = Math.random();
        }
        calculatorMock.a = String.valueOf(a);
        calculatorMock.b = String.valueOf(b);
        calculatorPresenter.onDivideClicked();
        assertEquals(String.valueOf(a/b), calculatorMock.result);
    }
}