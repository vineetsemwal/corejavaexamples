package java8demos;

import java.util.Optional;

public class OptionalEx {

    public static void main(String args[]){
        Optional<Integer>optional=Optional.of(12);
        boolean present=optional.isPresent();
        if(present){
           int value =optional.get();
           System.out.println(value);
        }else {
            System.out.println("optional is empty");
        }
    }
}
