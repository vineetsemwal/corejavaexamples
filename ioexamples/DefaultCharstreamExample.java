package ioexamples;

import java.io.*;

public class DefaultCharstreamExample {

    public static void main(String args[]) throws IOException {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputStreamReader reader = new InputStreamReader(inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        try {
            int charRead;
            while ((charRead = reader.read()) > 0) {
               System.out.println("char code="+charRead);
               char ch=(char)charRead;
               if(ch=='z'){
                 break;
               }
                writer.write(charRead);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            writer.close();
            inputStream.close();
            outputStream.close();
        }


    }
}
