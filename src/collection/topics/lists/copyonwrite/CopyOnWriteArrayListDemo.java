package collection.topics.lists.copyonwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Butter");

        System.out.println("Initial Shopping List: " + shoppingList);

        for (String items : shoppingList){ // Here Shopping List is the Snapshot after the Completion of Reading then only it will modify list.
            System.out.println(items);
            // Trying to Modify the list while Reading
            if(items.equals("Milk")){
                shoppingList.add("Chocolate Powder");
                System.out.println("Added Chocolate Powder to the List!");
            }
        }
        System.out.println("Total Items Present in Shopping List: " + shoppingList);

        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readerThread = new Thread(() -> {
            try {
                while (true) {
                    // Iterating through the list
                    for (String item : sharedList){
                        System.out.println("Reading Item: " + item);
                        Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in Reader Thread: " + e);
            }
        });

        Thread writerThread = new Thread(() -> {
           try {
               Thread.sleep(100);
               sharedList.add("Item4");
               System.out.println("Added Item4 to the Shopping List: " + shoppingList);

               Thread.sleep(500);
               sharedList.remove("Item1");
               System.out.println("Removed Item1 from the Shopping List: " + shoppingList);

           } catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        readerThread.start();
        writerThread.start();
    }
}
