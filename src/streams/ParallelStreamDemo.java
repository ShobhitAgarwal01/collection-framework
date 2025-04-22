package streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x-> x+1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken For Sequential Stream: " + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time Taken For Parallel Stream: " + (endTime - startTime) + " ms");


        // Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets

        // Cumulative Sum
        // [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15]
        // In lambda expressions local variables should be final or effectively final
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum =  new AtomicInteger(0);
        List<Integer> cumulativeSum = numbers.stream().sequential().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");
        System.out.println("Actual result with parallel stream: " + cumulativeSum);
    }

    private static long factorial(int n){
        long result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
