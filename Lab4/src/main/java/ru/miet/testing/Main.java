package ru.miet.testing;

import ru.miet.testing.interfaces.CalculatorPresenter;
import ru.miet.testing.interfaces.CalculatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements CalculatorView {
    public final JTextField inputA = new JTextField("", 5);
    public final JTextField inputB = new JTextField("", 5);
    public final JLabel output = new JLabel("",SwingConstants.CENTER);
    public final JLabel equals = new JLabel("=",SwingConstants.CENTER);
    public final JButton plus = new JButton("+");
    public final JButton minus = new JButton("-");
    public final JButton multiply = new JButton("*");
    public final JButton divide = new JButton("/");
    private final CalculatorPresenter calcPres;
    public String error;

    public Main() {
        super("Calculator");
        calcPres = new MyCalculatorPresenter(this);
        setBounds(325,125,650,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1,2,2));
        p1.add(new JLabel(""));
        inputA.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        inputA.setHorizontalAlignment(JTextField.CENTER);
        p1.add(inputA);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4,1,2,2));
        plus.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        minus.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        multiply.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        divide.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        p2.add(plus);
        p2.add(minus);
        p2.add(multiply);
        p2.add(divide);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(3,1,2,2));
        p3.add(new JLabel(""));
        inputB.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        inputB.setHorizontalAlignment(JTextField.CENTER);

        p3.add(inputB);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3,1,2,2));
        p4.add(new JLabel(""));
        equals.setFont(new Font(equals.getFont().getName(),Font.PLAIN,30));
        p4.add(equals);

        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        output.setFont(new Font(equals.getFont().getName(),Font.PLAIN,30));
        p5.add(output, BorderLayout.CENTER);

        container.setLayout(new GridLayout(1,5,2,2));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.add(p4);
        container.add(p5);

        plus.addActionListener(new PlusListener());
        minus.addActionListener(new MinusListener());
        multiply.addActionListener(new MultListener());
        divide.addActionListener(new DivListener());
    }

    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onPlusClicked();
        }
    }
    class MinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onMinusClicked();
        }
    }
    class MultListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onMultiplyClicked();
        }
    }
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calcPres.onDivideClicked();
        }
    }

    @Override
    public void printResult(double result) {
        output.setText(Double.toString(result));
    }
    @Override
    public void displayError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @Override
    public String getFirstArgumentAsString() {
        return inputA.getText();
    }
    @Override
    public String getSecondArgumentAsString() {
        return inputB.getText();
    }
    public static void main(String[] args) {
        var app = new Main();
        app.setVisible(true);
    }
}
