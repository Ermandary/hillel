package simple_calculator;

public class MyCalc<T extends Number> implements Calc<T> {
    @Override
    public T sum(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }

    @Override
    public T sub(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
    }

    @Override
    public T div(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
    }

    @Override
    public T mult(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
    }
}
