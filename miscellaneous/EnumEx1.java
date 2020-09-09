package miscellaneous;

import factory.Student;

public class EnumEx1 {

    public static void main(String args[]){
        Day sun=Day.SUNDAY;
        Day mon=Day.MONDAY;
        System.out.println("sun="+sun +" ordinal="+sun.ordinal());
        System.out.println("mon="+mon+" ordinal="+mon.ordinal());
        Day wed1=Day.WEDNESDAY;
        Day wed2=Day.WEDNESDAY;
        boolean identity=wed1==wed2;
        System.out.println("same object="+identity);

        Day days[]=Day.values();
        for (Day day:days){
            System.out.println(day+" ordinal="+day.ordinal());
        }
    }

}
