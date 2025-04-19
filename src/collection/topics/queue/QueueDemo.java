package collection.topics.queue;

import java.util.LinkedList;
import java.util.List;

public class QueueDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
//        list.addFirst(2);
//        list.addFirst(4);
//        list.addFirst(5);
//        list.removeFirst();

        list.addLast(23); // enqueue
        list.addLast(24); // enqueue
        list.addLast(25); // enqueue
        System.out.println(list);
        Integer i = list.removeFirst(); // dequeue
        System.out.println(list);
        list.getFirst(); // peek
    }
}
