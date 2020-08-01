package streamapidemos;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamApiEx4 {

    public static void main(String args[]){
       Stream<Integer>stream= Stream.of(1,2,3,4);
       /**
        Comparator<Integer>comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        };
        **/
        Comparator<Integer>  comparator=(a,b)->a-b;
        Optional<Integer>optional =stream.max(comparator);
        if(optional.isPresent()){
            int max=optional.get();
            System.out.println("max number="+max);
        }
    }
}
