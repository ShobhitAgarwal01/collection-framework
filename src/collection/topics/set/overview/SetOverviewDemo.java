package collection.topics.set.overview;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverviewDemo {
    public static void main(String[] args) {
        NavigableSet<Integer> set = new TreeSet<>(); // We can also use SortedSet as well
        set.add(12);set.add(1);
        set.add(1);set.add(67);
        System.out.println(set);
        System.out.println(set.remove(12));
        System.out.println(set.contains(67));
        set.clear();
        System.out.println(set.isEmpty());
        for( int i : set) {
            System.out.println(i);
        }

        // for thread safety
//        Set<Integer> integers = Collections.synchronizedSet(set); // We will not be using this as it will be blocking the tasks
        Set<Integer> threadSafety = new ConcurrentSkipListSet<>(); // It implements NavigableSet and built-in thread safety.

        Set<Integer> syncSet = Collections.synchronizedSet(new TreeSet<>());

        synchronized (syncSet) {
            for (Integer i : syncSet) {
                // Safe Iteration
                System.out.println(i);
            }
        }

        // Unmodifiable
        Set<Integer> set1 = Set.of(1,2,3,4,5,6,7,8,9,0,12,13,14,15,16);
    }
}
