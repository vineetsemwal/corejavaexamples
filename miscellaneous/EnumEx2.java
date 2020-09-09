package miscellaneous;

public class EnumEx2 {

    public static void main(String args[]){
        Break morningTea=Break.MORNING_TEA;
        String morningTeaTime=morningTea.getTime();

        Break lunch=Break.LUNCH;
        String lunchTime=lunch.getTime();

        Break eveningTea=Break.EVENING_TEA;
        String eveningTeaTime=eveningTea.getTime();


        System.out.println("morning time="+morningTeaTime);
        System.out.println("lunch time="+lunchTime);
        System.out.println("evening time="+eveningTeaTime);


    }

}
