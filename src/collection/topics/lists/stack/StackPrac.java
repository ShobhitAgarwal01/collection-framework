package collection.topics.lists.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackPrac {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        Integer removedElement = stack.pop();
        System.out.println(removedElement);
        System.out.println(stack);

        stack.peek(); // Used to see the elements present in a stack
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.remove(2); // We can also remove an element
        int search = stack.search(3); // Searches an Element from the Top
        System.out.println(search);

        // LinkedList as Stack

        LinkedList<Integer> stackObj = new LinkedList<>();
        stackObj.addLast(1);
        stackObj.addLast(2);
        stackObj.addLast(3);
        stackObj.getLast(); // peek
        stackObj.removeLast(); // pop
        stackObj.size();
        stackObj.isEmpty();

        // ArrayList as Stack?
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.get(arrayList.size() - 1); // peek
        arrayList.remove(arrayList.size() - 1); // pop
    }
}