package comparable;


import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Shobhit", 3.5));
        list.add(new Student("Xiao",3.9));
        list.add(new Student("Lin", 3.7));
        list.sort(null);
        System.out.println(list);

//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(2);
//        numbers.add(4);
//        numbers.add(1);
//        numbers.sort(null);
//        System.out.println(numbers);
    }
}


class Student implements Comparable<Student>{
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public double getGpa() {
        return gpa;
    }

    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }
}
