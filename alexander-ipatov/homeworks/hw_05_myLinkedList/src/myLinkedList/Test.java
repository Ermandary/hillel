package myLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add("Alex");
        list.add("Masha");
        list.add("Sasha");

        list.forEach(System.out::println);

        list.remove(1);
        list.remove("Sasha");

        System.out.println();
        list.forEach(System.out::println);
        list.clear();

        System.out.println();
        System.out.println(list.isEmpty());
    }
}
