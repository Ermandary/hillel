package factory_and_nullobject.persons;

public class NullPerson implements Person {
    @Override
    public void doSomething() {
        System.out.println("I don't do anything");
    }
}
