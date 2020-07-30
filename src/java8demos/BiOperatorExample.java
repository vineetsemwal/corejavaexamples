package java8demos;

import java.util.function.*;

public class BiOperatorExample {

    public static void main(String args[]){
        BinaryOperator<Integer>add=(num1,num2)->num1+num2;
       // BiFunction<Integer,Integer,Integer> addFun=(num1,num2)->num1+num2;
        int addResult=add.apply(1,2);
        System.out.println("add result is "+addResult);
        BinaryOperator<String>concat=(str1,str2)->str1+str2;
       //BiFunction<String,String,String> concatFun=(str1,str2)->str1+str2;
        String concatResult=concat.apply("hello","trainees");
        System.out.println("concat result is "+concatResult);
    }
}
