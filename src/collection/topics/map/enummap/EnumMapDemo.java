package collection.topics.map.enummap;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        Map<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.TUESDAY, "GYM");
        enumMap.put(Day.MONDAY, "STUDY");
        System.out.println(Day.TUESDAY.ordinal());
        System.out.println(enumMap);
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
