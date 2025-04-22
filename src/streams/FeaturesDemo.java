package streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FeaturesDemo {
    public static void main(String[] args) {
        // Streams
        // Java8 --> minimal code, functional programming, lambda expressions, Streams, Date & Time API

        // Lambda Expression --> Is an anonymous function (no name, no return type, no access modifier)
        Thread t1 = new Thread(()-> System.out.println("hello"));

        // Functional Interface can hold Lambda Expression

        MathOperation sum = (x, y) -> x + y;
        int res = sum.operate(4,6);
        System.out.println(res);

        // Predicate --> A Functional Interface (Boolean Valued Function)
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(5));
        Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("A");
        Predicate<String> isWordEndingWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> word = isWordEndingWithT.and(isWordEndingWithT);
        System.out.println(word.test("Shobhit"));


        // Function --> Work for you
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(tripleIt.andThen(doubleIt).apply(20)); // answer will be same
        System.out.println(doubleIt.compose(tripleIt).apply(20)); // answer will be same
        System.out.println(doubleIt.apply(100));
        Function<Integer, Integer> identity = Function.identity();
        Integer result = identity.apply(5);
        System.out.println(result);


        // Consumer
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(45);
        List<Integer> list = Arrays.asList(1,2,3,4);
        Consumer<List<Integer>> printList = x -> {
            for ( int i : x ){
                System.out.println(i);
            }
        };
        printList.accept(list);


        // Supplier --> It only gives, doesn't take anything
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());

        // Combined Example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        Supplier<Integer> supplier1 = () -> 100;

        if(predicate.test(supplier1.get())){
            consumer.accept(function.apply(supplier1.get()));
        }

        // Bi-Predicate, Bi-Function, Bi-Consumer
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 7));
        BiConsumer<Integer, Integer> biConsumer = (x , y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction  = (x , y) ->  (x + y).length();
        System.out.println(biFunction.apply("a", "bcd"));

        // Unary Operator, BinaryOperator
        UnaryOperator<Integer> unaryOperator = x -> 2 * x; // This Extends Function, so it will give same output as Function
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;

        // Method Reference --> use method without Invoking & in place of lambda Expression
        List<String> nameList = Arrays.asList("Shobhit", "LinDong", "XiaoYan");
        nameList.forEach(System.out::println);

        // Constructor Reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).toList();

    }
}

class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}


@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}