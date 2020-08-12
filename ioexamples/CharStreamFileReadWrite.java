package ioexamples;

import java.io.*;

public class CharStreamFileReadWrite {

        public static void main(String args[]) throws IOException {
            File inputFile = new File("C:/Users/vineet/work/ioexperiment/originalfile.txt");
            File outFile = new File("C:/Users/vineet/work/ioexperiment/copy.txt");
            InputStreamReader reader = new FileReader(inputFile);
            BufferedReader bufferedReader=new BufferedReader(reader);
            OutputStreamWriter writer = new FileWriter(outFile);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            try {
                int charRead;
                int charsReadCount=0;
                int vowelsCount=0;
                while ((charRead = bufferedReader.read()) > 0) {
                     char ch=(char)charRead;
                     if(ch=='a' || ch=='e' || ch=='i'|| ch=='o' || ch=='u'){
                       vowelsCount++;
                     }
                    bufferedWriter.write(charRead);
                    charsReadCount++;
                }
                System.out.println("chars read and write ="+charsReadCount);
                System.out.println("vowels present in file="+vowelsCount);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                bufferedReader.close();
                bufferedWriter.close();
                reader.close();
                writer.close();

            }


        }


}
