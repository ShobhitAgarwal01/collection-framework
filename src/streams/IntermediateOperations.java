package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They're lazy, meaning they don't execute until a terminal operation is invoked

        // 1. Filter
        List<String> list = Arrays.asList("Shobhit", "Xiao","TangSan", "LinDong");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("X"));
        // No Filtering at this point
        long result = list.stream().filter(x->x.startsWith("A")).count();
        System.out.println(result);

        // 2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. Sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamComp = list.stream().sorted((a, b) -> a.length() - b.length());

        // 4. Distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. Limit
        System.out.println(Stream.iterate(1, x-> x + 1).limit(100).count());

        // 6. Skip
        System.out.println(Stream.iterate(1, x-> x + 1).skip(10).limit(100).count());

        // 7. peek
        // Performs an action on each element as it is consumed
        Stream.iterate(1, x-> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatmap
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., list within lists) so that they can be processed as a single sequence of elements
        // Transform and Flatten elements at the same time
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Banana", "Apple"),
                Arrays.asList("PineApple","Guava"),
                Arrays.asList("Mango","Orange")
        );

        System.out.println(listOfLists
                .stream()
                .flatMap(x-> x.stream())
                .map(String::toUpperCase)
                .toList()
        );
        List<String> sentences = Arrays.asList("Hello World", "Java Streams are Powerful", "FlatMap is useful");

        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList()
        );


    }
}
