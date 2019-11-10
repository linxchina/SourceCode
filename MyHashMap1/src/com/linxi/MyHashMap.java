package com.linxi;

public class MyHashMap<K,V>{
    private MyEntry[] table;
    private static Integer CAPACITY=8;
    private int size=0;

    public MyHashMap() {
        this.table = new MyEntry[CAPACITY];
    }
    public int size(){
        return this.size;
    }
    public  Object get(Object key){
        int hash=key.hashCode();
        int i=hash%CAPACITY;
        for(MyEntry<K,V> entry=table[i];entry!=null;entry=entry.next){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
    public V put(K key,V value){

        int hash=key.hashCode();
        int i=hash%CAPACITY;
        for(MyEntry<K,V> entry=table[i];entry!=null;entry=entry.next){
            if(entry.getKey().equals(key)){
                V old= entry.getValue();
                entry.setValue(value);
                return old;
            }
        }
        addEntry(key, value, i);
        return value;
    }

    private void addEntry(K key, V value, int i) {
        this.size++;
        MyEntry entry=new MyEntry(key,value,table[i]);
        table[i]=entry;
    }

    public static void main(String[] args) {
        MyHashMap<String,String> map=new MyHashMap();
        map.put("111","1111");
        map.put("222","222");
        System.out.println(map.get("111"));
    }
}
