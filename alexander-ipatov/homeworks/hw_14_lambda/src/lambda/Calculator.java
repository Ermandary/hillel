package lambda;

@FunctionalInterface
public interface Calculator {
    Double calculate(Double a, Double b);

    default Double div(Double a, Double b) {
        return a / b;
    }

    static Double mult(Double a, Double b) {
        return a * b;
    }
}

