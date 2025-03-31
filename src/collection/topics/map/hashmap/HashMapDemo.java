package collection.topics.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(17, 0.6f); // Here we can declare the size of the array and give the load factor also
        hashMap.put(1, "Shobhit");
        hashMap.put(2, "Agarwal");
        hashMap.put(3, "Xiao");

        System.out.println(hashMap);

        String student = hashMap.get(3);
        System.out.println(student);

        for (boolean b : new boolean[]{(hashMap.containsKey(2)), hashMap.containsValue("Tempo")}) {
            System.out.println(b); // Checks whether the key is present or not and the value as well
        }

        Set<Integer> keys = hashMap.keySet();
        for (int i : keys) {
            System.out.println(hashMap.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for( Map.Entry<Integer, String> entry : entries) {
            entry.setValue(entry.getValue().toUpperCase());
            System.out.println(entry.getKey() +": " + entry.getValue());
        }

        hashMap.remove(1);
        boolean res = hashMap.remove(2, "Shobhit");
        System.out.println("Element Removed ? " + res);


    }
}
