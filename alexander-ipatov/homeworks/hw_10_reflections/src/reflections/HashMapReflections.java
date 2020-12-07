package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapReflections {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Object> hashMapInfo = HashMap.class;
        Constructor<? extends Object> constructor = hashMapInfo.getConstructor();

        HashMap<Integer, String> hashMapClass = (HashMap<Integer, String>) constructor.newInstance();

        Method methodPut = hashMapInfo.getMethod("put", Object.class, Object.class);

        methodPut.invoke(hashMapClass, 1, "Alex");
        methodPut.invoke(hashMapClass, 2, "Dima");
        methodPut.invoke(hashMapClass, 3, "Vlad");

        Method methodEntrySet = hashMapInfo.getMethod("entrySet");

        Set<HashMap.Entry<Integer, String>> setValues = (Set<HashMap.Entry<Integer, String>>) methodEntrySet.invoke(hashMapClass);

        System.out.println("элементы коллекции hashMapClass: ");
        for (Map.Entry<Integer, String> pair : setValues) {
            int key = pair.getKey();
            String value = pair.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("hashMapClass является HashMap: " + (hashMapClass instanceof HashMap));

        System.out.println("родительский класс класса HashMap: " + hashMapInfo.getSuperclass().getName());

        System.out.println("HashMap реализует следующие интерфейсы:");
        Class<? extends Object>[] interfaces = hashMapInfo.getInterfaces();
        for (Class interfaze : interfaces) {
            System.out.println(interfaze.getName());
        }
    }
}

/*
1. Создать через отражение экземпляр класса HashMap

	1.1. Добавить несколько элемента одного типа

	1.2. Получить элементы и вывести на экран

	1.3. Проверить что экземпляр является тем, который мы ожидаем.

	1.4. Вывести на экран родительский класс класса HashMap

	1.5. Вывести реализуемые интерфейсы классом HashMap
*/

