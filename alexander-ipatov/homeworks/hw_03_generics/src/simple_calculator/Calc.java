package simple_calculator;

public interface Calc<T extends Number> {
    T sum(T a, T b);

    T sub(T a, T b);

    T div(T a, T b);

    T mult(T a, T b);
}

