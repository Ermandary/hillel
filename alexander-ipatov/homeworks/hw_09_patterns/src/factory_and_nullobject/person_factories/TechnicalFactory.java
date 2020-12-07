package factory_and_nullobject.person_factories;

import factory_and_nullobject.persons.Person;
import factory_and_nullobject.persons.Programmer;

public class TechnicalFactory implements PersonFactory {
    @Override
    public Person createPerson() {
        return new Programmer();
    }
}
