import java.util.*;

public class MyArrayList<E> implements List<E> {
    private Object[] array;
    private int size = 0;
    private int MIN_CAPACITY = 10;

    public MyArrayList() {
        array = new Object[MIN_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Неверный размер массива");
        } else array = new Object[capacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        boolean result = false;
        if (indexOf(element) != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                return array(count++);
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public boolean add(E element) {
        size++;
        if (size > array.length) {
            array = increase(array);
        }
        array[size - 1] = element;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        boolean result = false;
        if (indexOf(element) != -1) {
            remove(indexOf(element));
            result = true;
        }
        return result;
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
    public void clear() {
        array = new Object[MIN_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return array(index);
    }

    @Override
    public E set(int index, Object element) {
        checkIndex(index);
        E oldElement = array(index);
        array[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        size++;
        if (size > array.length) {
            array = increase(array);
        }
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = element;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldElement = array(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null;
        return oldElement;
    }

    @Override
    public int indexOf(Object element) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(Object element) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(element)) {
                result = i;
            }
        }
        return result;
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

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private Object[] increase(Object[] array) {
        return Arrays.copyOf(array, (array.length * 3) / 2 + 1);
    }

    private void checkIndex(int index) {
        if (index < 0 | index >= size) {
            throw new ArrayIndexOutOfBoundsException("Неверный индекс");
        }
    }

    private E array(int index) {
        return (E) array[index];
    }
}
