package collection.topics.lists.arraylist;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ArrayList {

    public static void main(String[] args) throws Exception {

        java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<>(4);

        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(10);

        System.out.println("Element Present at index of Array : " + arrayList.get(2));
        System.out.println("Size of Array: " + arrayList.size());

        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        for(int x : arrayList){
            System.out.println(x);
        }
        System.out.println(arrayList.contains(2));
        System.out.println(arrayList.contains(50));

        arrayList.remove(2);

        arrayList.add(2, 50); /* To add in between of indexes */

        for(int x : arrayList){
            System.out.println(x);
        }

        arrayList.set(2,23); /* Will Replace */

        for (int x : arrayList){
            System.out.println(x);
        }

        Field field = java.util.ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.add(1);

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.remove(1);
        arrayList.remove(2);

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.trimToSize(); // trims to the size of array

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        /* Number of ways we can create an array */
        java.util.ArrayList<String> arrayList1 = new java.util.ArrayList<>();

        List<String> list = new java.util.ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());
        list1.set(1,"Wednesday");
        System.out.println(list1.get(1));

        String[] array = {"Apple", "Banana", "Custard Apple"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());
    }
}
