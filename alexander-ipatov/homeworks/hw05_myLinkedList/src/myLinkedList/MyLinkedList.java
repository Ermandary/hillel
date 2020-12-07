package myLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List {

    private Node first;
    private Node last;
    private int size;

    class Node {
        private Node prev;
        private Node next;
        private Object element;

        public Node(Node prev, Node next, Object element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Object next() {
                return get(count++);
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object element) {
        Node newElement = new Node(last, null, element);
        if (first == null) {
            first = newElement;
        } else {
            last.next = newElement;
        }
        last = newElement;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNode(index).element;
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        Node current = getNode(index);
        Object oldElement = current.element;
        current.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, Object element) {
        checkPosition(index);
        if (index == size) {
            add(element);
        } else {
            Node current = getNode(index);
            Node prev = current.prev;
            Node newNode = new Node(prev, current, element);
            prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public Object remove(int index) {
        Node deleteNode = getNode(index);
        Object deleteElement = deleteNode.element;
        Node prev = deleteNode.prev;
        Node next = deleteNode.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        deleteNode.prev = null;
        deleteNode.next = null;
        deleteNode.element = null;
        size--;

        return deleteElement;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node getNode(int index) {
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public Object getFirst() {
        return first;
    }

    public Object getLast() {
        return last;
    }

    private void checkIndex(int index) {
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }

    private void checkPosition(int index) {
        if (index < 0 | index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }
}

