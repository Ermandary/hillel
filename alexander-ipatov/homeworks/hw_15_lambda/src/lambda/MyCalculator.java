package lambda;

import java.util.HashMap;

public class MyCalculator {
    private final HashMap<Character, Calculator> table = new HashMap<>();

    private Calculator sub = (a, b) -> a - b;

    {
        table.put('+', (a, b) -> a + b);
        table.put('-', (a, b) -> sub.calculate(a, b));
        table.put('*', (a, b) -> sub.div(a, b));
        table.put('/', sub::div);
    }

    public Double calculate(Double a, Double b, char operation) {
        Calculator q = table.get(operation);
        return q.calculate(a, b);
    }
}

//Сделать задание из презентации:
//Реализовать функциональный интерфейс "calculate" (для калькулятора), который принимает и возвращает числовое значение одного и того же типа.
//Интерфейс должен иметь предопределенные методы по умолчанию для выполнения математических операций.
//Реализовать класс с хеш-таблицей интерфейсов "calculate", который будет возвращать лямбда выражение, ключом которому служит знак математической операции.
//Часть реализации можно использовать из функционального интерфейса “calculate”.