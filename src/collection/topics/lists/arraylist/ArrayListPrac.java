package collection.topics.lists.arraylist;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayListPrac {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arrayList = new ArrayList<>(4);

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
        System.out.println(arrayList.contains(2)); // Checking the Existence if it is present or not
        System.out.println(arrayList.contains(50));

        arrayList.remove(2); // Removes the Element at that Particular Index

        arrayList.add(2, 50); /* To add in between of indexes */

        for(int x : arrayList){
            System.out.println(x);
        }

        arrayList.set(2,23); /* Will Replace */

        for (int x : arrayList){
            System.out.println(x);
        }

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.add(1);

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.remove(1); /* We can remove elements by Index or By Value */
        arrayList.remove(2);

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        arrayList.trimToSize(); // trims to the size of array

        elementData = (Object[]) field.get(arrayList);
        System.out.println("ArrayList Capacity: " + elementData.length);

        /* Creating an Array */
        // Default Constructor, creates an empty arrayList with initial Capacity of size 10
        ArrayList<String> arrayList1 = new ArrayList<>();

        // Creating an ArrayList with a specified initial capacity
        ArrayList<String> arrayList2 = new ArrayList<>(20);

        // Creating an ArrayList from another collection
        List<String> stringList = Arrays.asList("Apple","Banana");
        ArrayList<String> arrayList3 = new ArrayList<>(stringList);

        /* Number of ways we can create an array */
        ArrayList<String> arrayList4 = new ArrayList<>();

        List<String> listObj = new ArrayList<>();
        System.out.println(listObj.getClass().getName());

        List<String> list1 = Arrays.asList("Monday", "Tuesday"); /* returns a fixed size array, cannot be re-sizeable, that's why we have to convert them to Array List*/
        System.out.println(list1.getClass().getName());
        list1.set(1,"Wednesday");
        System.out.println(list1.get(1));

        String[] array = {"Apple", "Banana", "Custard Apple"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());

        /* To add new elements in the array */
        List<String> arraStrings = new ArrayList<>(list2);
        arraStrings.add("Guava");
        System.out.println(arraStrings.get(3));

        List<Integer> list = List.of(1, 2, 3, 4); /* Immutable List, can pass any number of parameters */


        /* Adding Elements in ArrayList */
        List<Integer> listForInt = new ArrayList<>();
        listForInt.add(1);
        listForInt.add(2);
        listForInt.add(3);

        listForInt.add(4, 78); // We can add at a particular Index as well using .add
        System.out.println(listForInt);

        List<Integer> list3 = List.of(1, 2, 3, 4, 5);
        listForInt.addAll(list3); /* Can be used different list to append */

        /* Accessing the Elements */
        Integer fruit = listForInt.get(1);

        /* Removing Elements */
        list3.remove(3); // Here at 3rd Index the value is removed
        list3.remove(Integer.valueOf(3)); // Here the value present on 3rd index will be removed

        /* Converting to Array from List*/
        Object[] arr = list3.toArray();
        Integer[] arr1 = list3.toArray(new Integer[0]);

        /* Sorting a list */
        Collections.sort(list3);
        System.out.println("Sorted Listed is: "+list3);

        /* There are two different ways to print a list in ascending order*/
        list3.sort(null); /* This will print in ascending order */
        list3.sort(new MyComparator());

        List<String> words = Arrays.asList("Phone", "Mobile", "Laptop");
        words.sort(new StringLengthComparator()); // We can also use lambda expression than this too see the below example
//        words.sort((a,b) -> b.length() - a.length());
        System.out.println(words);


        List<Student> student = new ArrayList<>();
        student.add(new Student("Shobhit",4.5));
        student.add(new Student("Xiao", 3.76));
        student.add(new Student("Lin Dong", 4.97));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        student.sort((o1, o2) -> {
            if(o2.getGpa() - o1.getGpa() > 0){
                return 1;
            } else if (o2.getGpa() - o1.getGpa() < 0){
                return -1;
            } else {
                return o1.getName().compareTo(o2.getName()); // compares based on the name, if the gpa is same
            }
        });

        for (Student student1 : student){
            System.out.println(student1.getName() + " " + student1.getGpa());
        }
    }
}
/* Points to Remember
* i.  If our return type of compare method is negative then it will print in ascending order
* ii. If our return type of compare method is positive then it will print in descending order*/

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; /* This will get us in descending order, like when if we want the positive number after subtraction then our o2 should be greater otherwise if we are selecting o1- o2 then it is going to print in ascending order */
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
}