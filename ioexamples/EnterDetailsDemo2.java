package ioexamples;

import java.util.Scanner;

public class EnterDetailsDemo2 {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter name");
        String name=scanner.next();
        System.out.println("enter age");
        int age=scanner.nextInt();
        System.out.println("enter salary");
        double salary=scanner.nextDouble();

        System.out.println("name="+name+" age="+age+" salary="+salary);
    }
}
