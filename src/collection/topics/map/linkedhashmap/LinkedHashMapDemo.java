package collection.topics.map.linkedhashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11,0.85f, false);
        linkedHashMap.put("Orange", 12);
        linkedHashMap.put("Apple", 23);
        linkedHashMap.put("Guava", 34);

        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap);

        hashMap.put("Shobhit", 23);
        hashMap.put("Xiao", 24);
        hashMap.put("Tang San", 25);

        Integer res = hashMap.getOrDefault("Shobhit", 0);
        hashMap.putIfAbsent("Lin Dong", 95);
        System.out.println(hashMap);
    }
}
