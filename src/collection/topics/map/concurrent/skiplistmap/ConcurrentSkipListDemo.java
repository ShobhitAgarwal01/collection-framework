package collection.topics.map.concurrent.skiplistmap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListDemo {
    public static void main(String[] args) {
        // MAP -- SORTED -- THREAD SAFE -- ConcurrentSkipListMap
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
        // We can use in multi-threaded environment
    }
}
