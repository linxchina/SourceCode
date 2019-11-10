package com.linxi;

import java.util.Map;

public class MyEntry<K,V> implements Map.Entry<K,V> {
    private final K key;
    private V value;
    MyEntry next;

    public MyEntry(K key, V value, MyEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        V old=value;
        this.value=value;
        return old;
    }

}