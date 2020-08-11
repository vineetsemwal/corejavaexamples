package ioexamples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DefaultOutputStreamWrite {

    public static void main(String args[]) throws Exception {
        OutputStream outputStream = System.out;
        try {
            String line = "how are you?";
            for (char ch : line.toCharArray()) {
                outputStream.write(ch);
            }

        } catch (IOException exception) {
            exception.printStackTrace();

        } finally {
            outputStream.close();

        }

    }
}
