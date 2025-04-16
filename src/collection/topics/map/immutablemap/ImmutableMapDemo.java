package collection.topics.map.immutablemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shobhit", 1);
        map1.put("Xiao", 2);

        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
//        map2.put("C", 3); throws Exception
        Map<String, Integer> map3 = Map.of("A", 1, "B", 2);
        map3.put("Akshit", 35);
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("LinDong", 88), Map.entry("YaoChen", 98));

    }
}
