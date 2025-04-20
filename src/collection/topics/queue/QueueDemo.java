package collection.topics.queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.add(23); // enqueue
        list.add(24); // enqueue
        list.add(25); // enqueue

        System.out.println(list);
        Integer i = list.remove(); // dequeue
        System.out.println(list);
        list.peek(); // peek

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);

        System.out.println(queue1.remove()); // throws exception if empty
        System.out.println(queue1.poll());

//        System.out.println(queue1.element()); // throws exception if empty
        System.out.println(queue1.peek());

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1));
        System.out.println(queue2.offer(2));


//        System.out.println(queue2.add(3)); // throws exception
        System.out.println(queue2.offer(3)); // false
    }
}
