package gc;

import java.lang.ref.WeakReference;

public class GarbageCollectorDemo {
    public static void main(String[] args) {
        /* This is called Strong Reference
        Phone phone = new Phone("Apple", "16 Pro Max");
        System.out.println(phone);
        phone = null;
        System.out.println(phone);
         */

        WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Apple", "16 Pro Max"));
        System.out.println(weakReference.get());
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (Exception exception) {

        }

        System.out.println(weakReference.get());
    }
}
class Phone {
    String name;

    String model;

    public Phone(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}