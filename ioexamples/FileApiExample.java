package ioexamples;

import java.io.*;

public class FileApiExample {

    public static void main(String[] args){
        File dir=new File("C:/Users/vineet/work");
        boolean isDir=dir.isDirectory();
        System.out.println("is our file dir? "+isDir);
        System.out.println("******************iterated files**********");
        if(isDir) {
            File files[] = dir.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                boolean isIteratedDir = file.isDirectory();
                System.out.println("filename=" + fileName);
                System.out.println("is iterated file dir? " + isIteratedDir);
            }
        }
    }
}
