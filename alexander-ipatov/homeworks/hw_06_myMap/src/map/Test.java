package map;

public class Test {
    public static void main(String[] args) {
        MyMap<Integer, Person> myMap = new MyMap<>();

        Person person1 = new Person("Alexander", "Ipatov", 23);
        Person person2 = new Person("Ivan", "Ivanuch", 48);
        Person person3 = new Person("Dmitriy", "Kovtan", 18);

        myMap.put(1, person1);
        myMap.put(2, person2);
        myMap.put(3, person3);

        for(Integer key : myMap.keySet()) {
            System.out.printf("key: %s, value %s \n", key, myMap.get(key));
        }
    }
}
//Реализовать свою коллекцию HashMap<K,V> (или на массивах или на связанных списках)
//Создать какой-то свой класс, переопределив в нем методы ХешКода и эквивалентности
//Сохранить объекты своего класса (с переопределенными методами)
// в свою хеш коллекцию (HashMap<K,V>)