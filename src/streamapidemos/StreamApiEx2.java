package streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamApiEx2 {

    public static void main(String[]args){
        List<Integer>numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Stream<Integer>stream=numbers.stream();
        Predicate<Integer>predicate=(num)->num%2==0;
        Stream<Integer>evenStream=stream.filter(predicate);
        Consumer<Integer>consumer=System.out::println;
        System.out.println("stream filtered, let us print the filtered stream");
        evenStream.forEach(consumer);

        System.out.println("doing again in one line");
        numbers.stream().filter(num->num%2==0).forEach(System.out::println);

    }

}
