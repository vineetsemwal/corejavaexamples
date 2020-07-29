package java8demos;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String args[]){
        /*
        Example of Function
        public interface IStringLength {

         int stringLength(String str);

          }
         */
        Function<String,Integer> function1=(arg)->arg.length();
        int length1=function1.apply("hello");
       int length2=function1.apply("hyderabad");

       System.out.println("length 1="+length1);
       System.out.println("length 2="+length2);
        Function<Integer,Integer> function2=(arg)->{
            return arg*arg;
        };
        int square=function2.apply(10);
        System.out.println("square="+square);

    }
}
