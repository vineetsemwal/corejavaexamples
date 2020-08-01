package java8demos;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[]args){
        /**
         * example
         public interface IPrint {

         void print(String msg);
         }
         */

        //lambda with method body
        Consumer<String> print1=(msg)->{
            System.out.println(msg);
        };
        System.out.println("lamda defined with body");
        print1.accept("hello");

        // lambda inline
        Consumer<String> print2=(msg)-> System.out.println(msg);
        System.out.println("lamda defined inline");
        print2.accept("hello");
    }

}
