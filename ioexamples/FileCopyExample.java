package ioexamples;

import java.io.*;

public class FileCopyExample {

    public static void main(String args[]) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bin=null;
        BufferedOutputStream bout=null;
        try {
            File inputFile = new File("C:/Users/vineet/work/ioexperiment/originalfile.txt");
            File outFile = new File("C:/Users/vineet/work/ioexperiment/copy.txt");
            outputStream=new FileOutputStream(outFile);
            inputStream = new FileInputStream(inputFile);
            bin=new BufferedInputStream(inputStream,2000); // file size 8000
            bout=new BufferedOutputStream(outputStream);
            int redByte=0;
            int totalBytes=0;
            while ((redByte=bin.read())>0){
                bout.write(redByte);
               totalBytes++;
            }
            System.out.println("total bytes read and write="+totalBytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bin.close();
            bout.close();
            inputStream.close();
            outputStream.close();

        }

    }

}
