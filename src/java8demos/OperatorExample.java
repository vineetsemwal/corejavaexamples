package java8demos;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorExample {

    public static void main(String args[]){
        //
        // unary operator is a special case of Function in which argument type and return type are same
        //
        UnaryOperator<Integer> doubleOperator=(arg1)->arg1+arg1;
     //   Function<Integer,Integer>doubleFun=(arg1)->arg1+arg1;
       int value1=doubleOperator.apply(10);
       System.out.println("value1="+value1);

       UnaryOperator<String>doubleConcat=(arg1)->arg1+arg1;
       String value2=doubleConcat.apply("hello");
       System.out.println("value2="+value2);

    }

}
