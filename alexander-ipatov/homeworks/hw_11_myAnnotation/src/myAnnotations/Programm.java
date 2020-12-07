package myAnnotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Programm {
    public static void main(String[] args) {
        Class classInfo = Person.class;
        Annotation[] annotations = classInfo.getAnnotations();

        System.out.println("Аннотации класса Person: ");
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("Аннотации полей класса Person");
        Field[] fields = classInfo.getDeclaredFields();
        for(Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            if (fieldAnnotations.length >= 1) {
                System.out.println("field: " + field.getName());
                for (Annotation annotation : fieldAnnotations) {
                    System.out.println("annonation: " + annotation);
                }
            }
        }

        System.out.println("Аннотации методов класса Person:");
        Method[] methods = classInfo.getMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            if (methodAnnotations.length >= 1) {
                System.out.println("method: " + method.getName());
                for (Annotation annotation : methodAnnotations) {
                    System.out.println("annonation: " + annotation);
                }
            }
        }
    }
}



//3. С помощью отражения получить информацию об аннотациях в данном классе.