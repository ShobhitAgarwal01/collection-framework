package collection.topics.map.hashtable;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<Integer, String>();
        table.put(1, "One");
        table.put(2, "Two");
        table.put(3, "Three");
        System.out.println(table);
        System.out.println("Value for Key 2: " + table.get(2));
        System.out.println("Does Key 3 Exist: ? " + table.containsKey(3));
        table.remove(1);
        System.out.println("After Removing Key 1: " + table);
//        table.put(null, "value");
//        table.put(4, null);

        Hashtable<Integer, String> map = new Hashtable<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0;i < 1000; i++){
                map.put(i, "Thread1");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1000;i < 2000; i++){
                map.put(i, "Thread2");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch ( InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final Size of HashMap: " + map.size());
    }
}
