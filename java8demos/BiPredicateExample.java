package java8demos;

import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[]args){
        BiPredicate<Integer,Integer>sumEven1=(num1,num2)->(num1+num2)%2==0;
        BiPredicate<Integer,Integer>sumEven2=(num1,num2)->{
          int add=  num1+num2;
          boolean result=add%2==0;
          return result;
        };

        boolean isEven1=sumEven1.test(1,2);
        boolean isEven2=sumEven1.test(3,5);
        boolean isEven3=sumEven2.test(6,8);

        System.out.println("1+2 even? "+isEven1);
        System.out.println("3+5 even? "+isEven2);
        System.out.println("6+8 even? "+isEven3);

    }

}
