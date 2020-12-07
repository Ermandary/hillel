package factory_and_nullobject.person_factories;

import factory_and_nullobject.persons.NullPerson;
import factory_and_nullobject.persons.Person;

public class NullFactory implements PersonFactory {
    @Override
    public Person createPerson() {
        return new NullPerson();
    }
}
