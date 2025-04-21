package collection.topics.queue.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        // non-blocking, thread-safe double ended queue
        // Compare and Swap Strategy is used
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element1");
        deque.addFirst("Element2");
        deque.addLast("Element3");
        System.out.println(deque);

        String first = deque.removeFirst();
        String last = deque.removeLast();
    }
}
