package csv;

import java.io.File;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        File file = new File("aleksander-ipatov/homework/hw_17_csv/src/files/CsvFile.csv");
        DsvHandler handler = new DsvHandler(Person.class, ",");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Alex", "Velikiy", 23));
        personList.add(new Person("Dima", "Nemchinskiy", 13));
        personList.add(new Person("Bob", "Marli", 32));

        handler.save(personList, file);

        handler.load(file);
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
