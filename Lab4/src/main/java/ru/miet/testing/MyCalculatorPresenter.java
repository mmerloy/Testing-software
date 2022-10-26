package ru.miet.testing;

public class MyCalculatorPresenter implements CalculatorPresenter
{
    private final Calculator calculator;
    private final CalculatorView calculatorView;

    public MyCalculatorPresenter(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        calculator = new MyCalculator();
    }

    @Override
    public void onPlusClicked() {
        try {
            double a = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            double b = Double.parseDouble(calculatorView.getSecondArgumentAsString());
            calculatorView.printResult(calculator.sum(a,b));
        }catch (NumberFormatException e){
            calculatorView.displayError("Error! Wrong number!");
        }catch (NullPointerException e){
            calculatorView.displayError("Error! There is no input!");
        }
    }

    @Override
    public void onMinusClicked() {
        try {
            double a = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            double b = Double.parseDouble(calculatorView.getSecondArgumentAsString());
            calculatorView.printResult(calculator.subtract(a, b));
        }catch (NumberFormatException e){
            calculatorView.displayError("Error! Wrong number!");
        }catch (NullPointerException e){
            calculatorView.displayError("Error! There is no input!");
        }
    }

    @Override
    public void onDivideClicked() {
        try {
            double a = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            double b = Double.parseDouble(calculatorView.getSecondArgumentAsString());
            calculatorView.printResult(calculator.divide(a, b));
        }catch (NumberFormatException e){
            calculatorView.displayError("Error! Wrong number!");
        }catch (NullPointerException e){
            calculatorView.displayError("Error! There is no input!");
        }catch (ArithmeticException e){
            calculatorView.displayError("Error! I can't divide to \"0\"!");
            //calculatorView.displayError("You can't divide by zero");
        }
    }

    @Override
    public void onMultiplyClicked() {
        try {
            double a = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            double b = Double.parseDouble(calculatorView.getSecondArgumentAsString());
            calculatorView.printResult(calculator.multiply(a, b));
        }catch (NumberFormatException e){
            calculatorView.displayError("Error! Wrong number!");
        }catch (NullPointerException e){
            calculatorView.displayError("Error! There is no input!");
        }
    }
}
