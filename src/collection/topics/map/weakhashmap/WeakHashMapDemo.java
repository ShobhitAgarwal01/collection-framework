package collection.topics.map.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);

        System.out.println(imageCache);
        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache After Running (Some Entries Maybe Cleared)" + imageCache);
    }

    public static void loadCache(Map<String, Image> imageCache) {
        String k1 = new String("img1");
        String k2 = new String("img2");
        imageCache.put(k1, new Image("Image1"));
        imageCache.put(k2, new Image("Image2"));
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
        return name;
    }
}
