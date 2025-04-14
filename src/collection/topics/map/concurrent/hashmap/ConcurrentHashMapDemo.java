package collection.topics.map.concurrent.hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // Java 7 --> segment based locking --> 16 Segments --> Smaller HashMaps
        // Only the segment being written to or read is locked
        // Read: Do not require locking unless there is a write operation happening on the same segment.
        // Write: lock

        // Java 8 --> no segmentation
        // Compare-and-swap approach --> no locking except resizing pr collision
        // Thread A last saw --> x = 42
        // Thread A work --> x to 50
        // if x is still 45, then change it to 50, else don't change and retry
        // put --> index
    }
}
