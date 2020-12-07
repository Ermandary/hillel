package factory_and_nullobject.person_factories;

import factory_and_nullobject.persons.Artist;
import factory_and_nullobject.persons.Person;

public class HumanitiesFactory implements PersonFactory {
    @Override
    public Person createPerson() {
        return new Artist();
    }
}
