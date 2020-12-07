package map;

import java.util.*;

public class MyMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE / 2;
    private final int bucketCount;
    private List<List<Node<K, V>>> bucketList = new LinkedList<>();

    public MyMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyMap(int bucketCount) {
        if (bucketCount < 0) {
            throw new IllegalArgumentException();
        }
        if (bucketCount > MAXIMUM_CAPACITY) {
            this.bucketCount = MAXIMUM_CAPACITY;
        } else {
            this.bucketCount = bucketCount;
        }
        init(this.bucketCount);
    }

    private void init(int capacity) {
        for (int i = 0; i < capacity; i++) {
            bucketList.add(new LinkedList<>());
        }
    }

    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (List<Node<K, V>> list : bucketList) {
            size += list.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        checkKey(key);
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        checkValue(value);
        boolean result = false;
        for (List<Node<K, V>> bucket : bucketList) {
            for (Node<K, V> node : bucket) {
                if (value.equals(node.value)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public V get(Object key) {
        checkKey(key);
        K mark = (K) key;
        V result = null;
        List<Node<K, V>> bucket = bucketList.get(getBucketNumber(mark.hashCode()));
        for (Node<K, V> node : bucket) {
            if (key.equals(node.key)) {
                result = node.value;
                break;
            }
        }
        return result;
    }

    @Override
    public V put(K key, V value) {
        checkKey(key);
        checkValue(value);
        if (containsKey(key)) {
            Node current = getNode(key.hashCode());
            current.value = value;
        } else {
            bucketList
                    .get(getBucketNumber(key.hashCode()))
                    .add(new Node<>(key, value));
        }
        return value;
    }

    private int getBucketNumber(int hash) {
        int result = 0;
        int bucketSize = Integer.MAX_VALUE / bucketCount;
        int range = bucketSize;

        for (int i = 0; range < Integer.MAX_VALUE; i++, range += bucketSize) {
            if (Math.abs(hash) < range) {
                result = i;
                break;
            }
        }
        return result;
    }

    private Node getNode(int hash) {
        Node result = null;
        List<Node<K, V>> nodeList = bucketList.get(getBucketNumber(hash));
        for (Node<K, V> node : nodeList) {
            if (hash == node.key.hashCode()) {
                result = node;
            }
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        V result = null;
        checkKey(key);
        if (containsKey(key)) {
            List<Node<K, V>> nodeList = bucketList.get(getBucketNumber(key.hashCode()));
            for (Node<K, V> node : nodeList) {
                if (key.equals(node.key)) {
                    result = node.value;
                    nodeList.remove(node);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new IllegalStateException("данный метод не поддерживается");
    }

    @Override
    public void clear() {
        for (int i = 0; i < bucketList.size(); i++) {
            bucketList.get(i).clear();
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (List<Node<K, V>> bucket : bucketList) {
            for (Node<K, V> node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (List<Node<K, V>> bucket : bucketList) {
            for (Node<K, V> node : bucket) {
                values.add(node.value);
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new IllegalStateException("данный метод не поддерживается");
    }

    private void checkKey(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
    }

    private void checkValue(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
    }
}
