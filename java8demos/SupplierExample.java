package java8demos;

import java.util.function.Supplier;

public class SupplierExample {

    /**
     *
     * lambdas are instances of functional interfaces(interface with one method)
     */
    public static void main(String args[]){

        System.out.println("******inline lambda example*****");
        //
        // inline lambda example
        //
        Supplier<String>  greet2= () -> "hello";
        String msg2=greet2.get();
        System.out.println("msg2 from supplier2="+msg2);

        System.out.println("********lambda with body example");
        //
        // lambda with body
        //
        Supplier<String> greet3=()->{
            String msg="hello";
            return msg;
        };
        String msg3=greet3.get();
        System.out.println("msg3 from supplier3="+msg3);

    }

}
