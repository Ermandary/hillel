package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Object> myClassInfo = MyClassReflection.class;
        MyClassReflection myClass = new MyClassReflection();

        Field privateField = myClassInfo.getDeclaredField("age");
        privateField.setAccessible(true);
        privateField.set(myClass, 23);
        int age = privateField.getInt(myClass);

        Field publicField = myClassInfo.getField("name");
        String name = (String) publicField.get(myClass);

        System.out.println("Публичное поле: " + name);
        System.out.println("Приватное поле: " + age);

        System.out.println("получаем ClassCastException:");

        String x = (String) privateField.get(myClass);
    }
}

class MyClassReflection {
    public String name = "Alex";
    private int age = 20;

    public MyClassReflection() {
    }
}

/*
3. Создать свой класс с приватным полем и публичным.

	3.1. Динамически изменить значение приватного поля.

	3.2. Все вывести на экран.

    4. Получить ошибку ClassCastException
 */