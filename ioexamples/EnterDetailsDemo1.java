package ioexamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class EnterDetailsDemo1 {

    public static void main(String args[]) throws IOException{

        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String name=null;
        int age=-1;
        double salary=-1;
        try {
            System.out.println("enter name");
            String readLine = bufferedReader.readLine();
            name = readLine;

            System.out.println("enter age");
            String ageStr = bufferedReader.readLine();
            age = Integer.parseInt(ageStr);

            System.out.print("enter salary");
            String salStr=bufferedReader.readLine();
            salary=Double.parseDouble(salStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            reader.close();
        }

        System.out.print("age is "+age+" name="+name+ " salary="+salary);

    }

}
