package lambda;

public class Program {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();

        System.out.println(calculator.calculate(15.0, 5.0, '+'));
        System.out.println(calculator.calculate(15.0, 5.0, '-'));
        System.out.println(calculator.calculate(15.0, 5.0, '/'));
        System.out.println(calculator.calculate(15.0, 5.0, '*'));
    }
}
