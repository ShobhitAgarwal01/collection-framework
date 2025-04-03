package collection.topics.map.weakhashmap;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        imageCache.put("img1", new Image("Image1"));
        imageCache.put("img2", new Image("Image2"));

        System.out.println(imageCache);
        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache After Running (Some Entries Maybe Cleared)" + imageCache);
    }

    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulating Application Running");
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
