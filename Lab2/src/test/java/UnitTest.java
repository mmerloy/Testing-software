import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    private final Mock mock = new Mock();
    private final String[] errorMessages = {"Error! Wrong number!", "Error! There is no input!",
            "Error! I can't divide to \"0\"!"};
    private final CalculatorPresenter calculatorPresenter = new MyCalculatorPresenter(mock);

    @Test
    public void firstArgNullSum(){
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void secondArgNullSum(){
        mock.a = String.valueOf(Math.random());
        mock.b = null;
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void allArgsNullSum(){
        mock.a = null;
        mock.b = null;
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void firstArgNullSubtract(){
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void secondArgNullSubtract(){
        mock.a = String.valueOf(Math.random());
        mock.b = null;
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void firstArgNullMultiple(){
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void secondArgNullMultiple(){
        mock.a = String.valueOf(Math.random());
        mock.b = null;
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void firstArgNullDivide(){
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void secondArgNullDivide(){
        mock.a = String.valueOf(Math.random());
        mock.b = null;
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[1], mock.error);
    }

    @Test
    public void secondArgZeroDivide(){
        mock.a = String.valueOf(Math.random());
        mock.b = String.valueOf(Math.random()*10e-8);
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[2], mock.error);

    }

    @Test
    public void firstArgNotNumbersSum(){
        mock.a = "abcd";
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void secondArgNotNumbersSum(){
        mock.a = String.valueOf(Math.random());
        mock.b = "abcd";
        calculatorPresenter.onPlusClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void firstArgNotNumbersSubtract(){
        mock.a = "abcd";
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void secondArgNotNumbersSubtract(){
        mock.a = String.valueOf(Math.random());
        mock.b = "abcd";
        calculatorPresenter.onMinusClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void firstArgNotNumbersMultiple(){
        mock.a = "abcd";
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void secondArgNotNumbersMultiple(){
        mock.a = String.valueOf(Math.random());
        mock.b = "abcd";
        calculatorPresenter.onMultiplyClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void firstArgNotNumbersDivide(){
        mock.a = "abcd";
        mock.b = String.valueOf(Math.random());
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    @Test
    public void secondArgNotNumbersDivide(){
        mock.a = String.valueOf(Math.random());
        mock.b = "abcd";
        calculatorPresenter.onDivideClicked();
        assertEquals(errorMessages[0], mock.error);
    }

    //@RepeatedTest(10)
    @Test
    public void checkSum(){
        double a = 0.1;
        double b = 0.2;
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calculatorPresenter.onPlusClicked();
        assertEquals(String.valueOf(a+b), mock.result);
    }

    @RepeatedTest(10)
    public void checkSubtract(){
        double a = Math.random();
        double b = Math.random();
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calculatorPresenter.onMinusClicked();
        assertEquals(String.valueOf(a-b), mock.result);
    }

    @RepeatedTest(10)
    public void checkMultiple(){
        double a = Math.random();
        double b = Math.random();
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calculatorPresenter.onMultiplyClicked();
        assertEquals(String.valueOf(a*b), mock.result);
    }

    @RepeatedTest(10)
    void checkDivide(){
        double a = Math.random();
        double b = Math.random();
        while(b==0.0){
            b = Math.random();
        }
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calculatorPresenter.onDivideClicked();
        assertEquals(String.valueOf(a/b), mock.result);
    }
}