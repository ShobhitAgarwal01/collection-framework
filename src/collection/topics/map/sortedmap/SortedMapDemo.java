package collection.topics.map.sortedmap;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>((a, b) -> b - a); // This will give in the Descending order
        sortedMap.put(91, "Vivek");
        sortedMap.put(98,"Shobhit");
        sortedMap.put(96,"Xiao");
        sortedMap.put(88,"Tampu");
        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        System.out.println(sortedMap.headMap(91));
        System.out.println(sortedMap.tailMap(91));
    }
}
