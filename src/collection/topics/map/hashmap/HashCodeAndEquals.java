package collection.topics.map.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Shobhit", 1);
        Person p2 = new Person("Tempo", 2);
        Person p3 = new Person("Shobhit", 1);

        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager");

        System.out.println("HashMap Size: " + map.size());
        System.out.println("Value for P1: " + map.get(p1));
        System.out.println("Value for P3: " + map.get(p3));
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } if ( obj == null){
            return false;
        } if (getClass() != obj.getClass()){
            return false;
        }
        Person other = (Person) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
