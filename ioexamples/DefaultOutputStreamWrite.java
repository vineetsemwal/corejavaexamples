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
            inputStream = new FileInputStream(inputFile);
            outputStream = System.out;
            int bytesCount = 0;
            int redByte = -1;
            //inputStream.read() returns byte, when there is no more data to read, -1 be returned
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
