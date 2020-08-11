package ioexamples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultOutputStreamWrite {

    public static void main(String args[]) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File inputFile = new File("C:/Users/vineet/work/ioexperiment/originalfile.txt");
            outputStream = System.out;
            inputStream = new FileInputStream(inputFile);
            int bytesCount = 0;
            int redByte = -1;
            while ((redByte = inputStream.read()) > 0) {
                outputStream.write(redByte);
                bytesCount++;
            }
            System.out.println("bytes  read and write=" + bytesCount);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }


    }
}
