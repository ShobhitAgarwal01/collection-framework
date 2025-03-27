package collection.topics.lists.vector;

import java.util.LinkedList;
import java.util.Vector;

public class VectorPrac {
    public static void main(String[] args) {
        Vector<Integer> vectorObj = new Vector<>(12, 5);
        System.out.println(vectorObj.capacity());
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Vector<Integer> vector = new Vector<>(linkedList);
        System.out.println(vector);

        for(int i = 0; i< vector.size();i++){
            System.out.println(vector.get(i));
        }
        vector.clear();
        System.out.println(vector);

    }
}
