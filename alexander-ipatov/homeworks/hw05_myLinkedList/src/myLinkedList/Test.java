package myLinkedList;

import myArrayList.MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

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
