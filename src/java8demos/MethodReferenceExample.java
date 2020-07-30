package java8demos;

import java.util.function.*;

public class MethodReferenceExample {

    public static void main(String args[]){
        Util util=new Util();
        Consumer<String>printer1=(arg)->{
            System.out.println(arg);
        };

        printer1.accept("hello");

        Consumer<String>printer2= System.out::println;
        System.out.println("println method used");
        printer2.accept("hey");

        BinaryOperator<Integer> addOperator1=(num1, num2)->{
            Util adder=new Util();
            int result= adder.add(1,2);
            return result;
        } ;
        int op1Result=addOperator1.apply(5,7);
        System.out.println("op1 result="+op1Result);

        BinaryOperator<Integer>addOperator2=util::add;
        int op2Result=addOperator2.apply(1,2);
        System.out.println("op2 result="+op2Result);

        BiFunction<Integer,Integer,Integer>biFun2=util::add;
        int biFunResult=biFun2.apply(3,5);
        System.out.println("biFun result="+biFunResult);

        UnaryOperator<Integer>doubleOp1=(num)->num+num;
        int numDouble1=doubleOp1.apply(10);
        System.out.println("op1 num double="+numDouble1);
        UnaryOperator<Integer>doubleOp2=util::doubleNumber;
        int numDouble2=doubleOp2.apply(2);
        System.out.println("op2 num double="+numDouble2);

        Function<String,Integer>lengthOp1=(str)->str.length();
        int length1=lengthOp1.apply("hello");
        System.out.println("hello length="+length1);
        Function<String,Integer>lengthOp2=util::findLength;
        int length2=lengthOp2.apply("mumbai");
        System.out.println("mumbai length="+length2);

    }

}
