package java8demos;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String []args){

        //
        //concat two strings and return result
        //
        BiFunction<String,String,String>function1=(arg1,arg2)->arg1+arg2;
        String concat= function1.apply("hi","hello");
        System.out.println("concat result="+concat);
        //
        //concat number of times string with itself
        //
        BiFunction<String,Integer,String>function2=(str,times)->{
            String result="";
            for (int i=0;i<times;i++){
             result=result+str;
            }
            return result;
        };

        String twice=function2.apply("hello",2);
        System.out.println("concat twice="+twice);
        String thrice=function2.apply("bye",3);
        System.out.println("concat thrice="+thrice);



    }
}
