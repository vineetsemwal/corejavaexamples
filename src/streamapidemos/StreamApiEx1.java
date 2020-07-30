package streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamApiEx1 {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("mumbai");
        cities.add("delhi");
        cities.add("hyderabad");
        List<Integer> citiesLength = new ArrayList<>();
        /**
         * We are implementing needed operation
         */
        for (String city : cities) {
            int len = city.length();
            citiesLength.add(len);
        }

        for (int cityLength : citiesLength) {
            System.out.println(cityLength);
        }

        System.out.println("doing operation using stream");

        /**
         * We are NOT implementing operations, we are only declaring the needed operations
         */
        Stream<String>citiesStream=cities.stream();
        Function<String,Integer>function=(city)->city.length();
        Stream<Integer>lengthStream=citiesStream.map(function);// intermediate operation
        Consumer<Integer>consumer=System.out::println;
        System.out.println("operations defined on stream");
        //streams are lazy in nature ie. they will not executed until we do a terminal operation
        // on them like below
        //
        lengthStream.forEach(consumer);// terminal operation, we have used up the stream


        /**
         * We are NOT implementing operations, we are only declaring the needed operations
         */
        cities.stream().map(city->city.length()).forEach(System.out::println);



    }

}
