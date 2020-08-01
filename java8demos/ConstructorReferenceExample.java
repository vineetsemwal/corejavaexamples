package java8demos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    public static void main(String []args){
        Supplier<Car> carSupplier1=()->new Car();
        Supplier<Car> carSupplier2=Car::new;
        System.out.println("suppliers created");
        Car car1=carSupplier1.get();
        Car car2=carSupplier2.get();

        Supplier<List<Integer>>supplier1=()->{
           return new ArrayList<>();
        };

        Function<String,Car>carFun1=(name)->new Car(name);
        Function<String,Car>carFun2=Car::new;

        System.out.println("functions created");

        Car car3=carFun1.apply("maruti");
        Car car4=carFun2.apply("jeep");

        System.out.println("car 1="+car1.getName());
        System.out.println("car 2="+car2.getName());
        System.out.println("car 3="+car3.getName());
        System.out.println("car 4="+car4.getName());

        Supplier<List<Integer>>supplier2=ArrayList::new;

        System.out.println("suppliers created");
        List<Integer>list1=supplier1.get();
        System.out.println("supplier 1 list ="+list1);
        List<Integer>list2=supplier2.get();
        System.out.println("supplier 2 list="+list2);
     }

}
