package xml_handler;

import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        File file = new File("aleksander-ipatov/homework/hw_18_xml/src/files/MyXml.xml");
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person("Alex", "Velikiy", 23));
        personList.add(new Person("Dima", "Nemchinskiy", 13));
        personList.add(new Person("Bob", "Marli", 32));

        XmlHandler<Person> handler = new XmlHandler(Person.class);
        Document doc = handler.create(personList);
        handler.saveToFile(doc, file);

        List<Person> list = handler.load(file);
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
