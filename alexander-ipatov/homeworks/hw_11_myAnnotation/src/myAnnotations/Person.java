package myAnnotations;

@MyClassAnnotation(author = "Alexander", description = "class for testing myAnnotations")
public class Person {
    @MyFieldAnnotation(name = "name")
    private String name;

    @MyFieldAnnotation(name = "age", type = "int")
    private int age;

    @MyMethodAnnotation(name = "getName", returnType = "String")
    public String getName() {
        return name;
    }

    @MyMethodAnnotation(name = "setName")
    public void setName(String name) {
        this.name = name;
    }

    @MyMethodAnnotation(name = "getAge", returnType = "int")
    public int getAge() {
        return age;
    }

    @MyMethodAnnotation(name = "setAge")
    public void setAge(int age) {
        this.age = age;
    }
}
