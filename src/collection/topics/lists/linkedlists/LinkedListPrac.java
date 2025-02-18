package collection.topics.lists.linkedlists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class LinkedListPrac {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>(); /* If we're using List as our reference then we won't be able to access method addFirst(), addLast(), getFirst(), getLast()*/
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.get(0); // O(n)

        linkedList.addLast(4); // O(1)
        linkedList.addFirst(0); // O(1)

        linkedList.getFirst();
        linkedList.getLast();

        System.out.println(linkedList);
        linkedList.removeIf( x -> x % 2 == 0);
        System.out.println(linkedList);


        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Lion", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Cat"));
        animals.removeAll(animalsToRemove);

        System.out.println(animals);
    }
}
