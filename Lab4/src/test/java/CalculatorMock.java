import interfaces.CalculatorView;

public class CalculatorMock implements CalculatorView {
    public String result;
    public String error;
    public String a;
    public String b;

    @Override
    public void printResult(double result) {
        this.result = String.valueOf(result);
    }

    @Override
    public void displayError(String message) {
        this.error = message;
    }

    @Override
    public String getFirstArgumentAsString() {
        return this.a;
    }

    @Override
    public String getSecondArgumentAsString() {
        return this.b;
    }
}