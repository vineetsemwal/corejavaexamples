package streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample3 {


    /**
     *  convert from List<String> to List<Integer>
     *
     *   where the target list will only have even length
     *
     *
     */
    public static void main(String []args){

        List<String>names=new ArrayList<>();
        names.add("anuj");
        names.add("ankit");
        names.add("rahul");
        names.add("vineel");
        names.add("preethi");
        names.add("pratyusha");

        //
        //every operation we do on stream is run on every element of stream
        //
        Stream<String>stringStream=names.stream();
        Function<String,Integer>function=name->name.length();
        Stream<Integer>lengthStream=stringStream.map(function);
        Predicate<Integer>predicate=(num)->num%2==0;
        Stream<Integer>evenStream=lengthStream.filter(predicate);//1,2,3
        List<Integer>evenList1=evenStream.collect(Collectors.toList());   // terminal operation
        evenList1.forEach(System.out::println);
        System.out.println("doing in one line");
       List<Integer>evenList2 =names.stream().map(name->name.length()).filter(length->length%2==0).collect(Collectors.toList());
       evenList2.forEach(System.out::println);
    }
}
