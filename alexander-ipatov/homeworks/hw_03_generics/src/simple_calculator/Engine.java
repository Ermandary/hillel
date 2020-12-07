package simple_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private Calc calculator;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {

        init();

        double operand1 = getDouble();
        double operand2 = getDouble();
        char operation = getOperation();

        try {
            Number result = calculator(operand1, operand2, operation);
            System.out.println("Результат операции = " + result);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
    }

    private Number calculator(double operand1, double operand2, char operation) {
        Number result;

        switch (operation) {
            case '+':
                result = calculator.sum(operand1, operand2);
                break;
            case '-':
                result = calculator.sub(operand1, operand2);
                break;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException();
                }
                result = calculator.div(operand1, operand2);
                break;
            case '*':
                result = calculator.mult(operand1, operand2);
                break;
            default:
                System.out.println("Данная операция не поддерживается");
                result = -1;
        }
        return result;
    }

    public static double getDouble() {

        System.out.println("Введите число");

        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            System.out.println("неверный ввод");
            return -1;
        }
    }

    public static char getOperation() {

        System.out.println("Введите операцию");

        try {
            return (char) reader.read();
        } catch (IOException e) {
            System.out.println("Неверная операция");
            return 'q';
        }
    }

    private void init() {
        calculator = new MyCalc();
    }

}
