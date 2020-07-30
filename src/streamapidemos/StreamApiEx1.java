package streamapidemos;

import java.util.ArrayList;
import java.util.List;
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
        cities.stream().map(city->city.length()).forEach(System.out::println);


        Stream<String>citiesStream=cities.stream();
        Stream<Integer>lengthStream=citiesStream.map(city->city.length());// intermediate operation
        lengthStream.forEach(System.out::println);// terminal operation, we have used up the stream



    }

}
