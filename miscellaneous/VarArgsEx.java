package miscellaneous;

public class VarArgsEx {

    public static void main(String args[]){
        VarArgsEx ex=new VarArgsEx();
        int result1=ex.add(1,2);
        int result2=ex.add(1);
        int result3=ex.add(1,2,3,4,5);
        System.out.println("result1="+result1);
        System.out.println("result2="+result2);
        System.out.println("result3="+result3);
    }

    public int add(int ...numbers){
        int result=0;
        for (int number:numbers){
            result=result+number;
        }
        return result;
    }





}
