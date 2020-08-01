package java8demos;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String args[]){
        Predicate<Integer>predicate1=(num)->num%2==0;
        Predicate<Integer>predicate2=(num)->{
          boolean even=  num%2==0;
          return even;
        };

       System.out.println("predicates created ");

        boolean isEven1=predicate1.test(10);
        boolean isEven2=predicate1.test(11);
        boolean isEven3=predicate2.test(12);

        System.out.println("is 10 even="+isEven1);
        System.out.println("is 11 even="+isEven2);
        System.out.println("is 12 even="+isEven3);


    }

}
