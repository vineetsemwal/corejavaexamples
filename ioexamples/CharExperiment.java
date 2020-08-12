package ioexamples;

import java.io.*;

public class CharExperiment {

    public static void main(String []args) throws IOException {
        for(int i=0;i<2000;i++){
            char ch=(char)i;
            System.out.print(ch);
        }
    }
}
