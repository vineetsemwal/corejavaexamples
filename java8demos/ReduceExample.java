package java8demos;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceExample {

    public static void main(String args[]) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        BinaryOperator<Integer> operator = (a, b) -> a + b;
        Optional<Integer> optional = stream1.reduce(operator);
        if (optional.isPresent()) {
            int result = optional.get();
            System.out.println(result);
        }

        Integer numbers[] = {1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> stream2 = Arrays.stream(numbers);

        Optional<Integer> optional2 = stream2.reduce((a, b) -> a + b);

        if (optional2.isPresent()) {
            int result = optional2.get();
            System.out.println(result);
        }


    }

}
