package collection.topics.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 1);
        studentMap.put("Alice", 2);
        studentMap.put("Ram", 3);
        studentMap.put("Xiao", 4);

        System.out.println(studentMap);
    }
}
