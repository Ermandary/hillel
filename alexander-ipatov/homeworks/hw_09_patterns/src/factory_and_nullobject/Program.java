package factory_and_nullobject;

import factory_and_nullobject.person_factories.HumanitiesFactory;
import factory_and_nullobject.person_factories.NullFactory;
import factory_and_nullobject.person_factories.TechnicalFactory;
import factory_and_nullobject.persons.Person;

public class Program {
    private final static String HUMANITIES = "Artist";
    private final static String TECHNICAL = "Programmer";

    public static void main(String[] args) {
        Person person1 = create("Artist");
        Person person2 = create("Programmer");
        Person person3 = create("Fisher");

        person1.doSomething();
        person2.doSomething();
        person3.doSomething();
    }

    public static Person create(String person) {
        Person returnPerson;
        switch (person) {
            case HUMANITIES:
                returnPerson = new HumanitiesFactory().createPerson();
                break;
            case TECHNICAL:
                returnPerson = new TechnicalFactory().createPerson();
                break;
            default:
                returnPerson = new NullFactory().createPerson();
        }
        return returnPerson;
    }
}
