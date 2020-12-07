package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ArrayListReflections {
    public static void main(String[] args) {
        Class<? extends Object> arrayClassInfo = ArrayList.class;
        Method[] openedMethods = arrayClassInfo.getMethods();
        System.out.println("Открытые методы класса ArrayList:");
        for(Method method : openedMethods) {
            System.out.println(method.getName());
        }

        Field[] openedFields = arrayClassInfo.getFields();
        System.out.println("Открытые поля класса ArrayList:");
        for(Field field : openedFields) {
            System.out.println(field.getName());
        }

        Method[] hiddenMethods = arrayClassInfo.getDeclaredMethods();
        System.out.println("Приватные и защищённые методы класса ArrayList:");
        for(Method method : hiddenMethods) {
            int mods = method.getModifiers();
            if(Modifier.isPrivate(mods) || Modifier.isProtected(mods)){
                System.out.println(method.getName());
            }
        }

        Field[] hiddenFields = arrayClassInfo.getDeclaredFields();
        System.out.println("Приватные и защищённые поля класса ArrayList:");
        for(Field field : hiddenFields) {
            int mods = field.getModifiers();
            if(Modifier.isPrivate(mods) || Modifier.isProtected(mods)) {
                System.out.println(field.getName());
            }
        }
    }
}

/*
2. Вывести на экран все открытые методы и поля класса ArrayList

	2.1. Вывести на экран все скрытые данные класса ArrayList
*/


