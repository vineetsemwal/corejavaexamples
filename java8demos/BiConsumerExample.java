package java8demos;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        /**
         Biconsumer example
         public interface IGreetWithName {

         void greet(String name, String msg);
         }

         */

        BiConsumer<String,Double> consumer1 = (arg1, arg2) -> System.out.println(arg1 + " " + arg2);
        consumer1.accept("ankit", 10.2);

        BiConsumer<String,String>consumer2 = (msg1, msg2) -> {
            System.out.println(msg1 + " " + msg2);
        };
        consumer2.accept("pradeep", "hi");


    }


}

