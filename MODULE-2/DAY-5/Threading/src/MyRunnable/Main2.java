package MyRunnable;

import java.io.*;

public class Main2  extends Thread {
    private static OutputStream destinationWriter;
    private InputStream sourceReader;
    public Main2(String name,InputStream sourcereader){
        super(name);
        this.sourceReader=sourcereader;
    }
    public static void openDestinationWriter(){
        try {
            Main2.destinationWriter = new FileOutputStream("Output.log");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void closeDestinationWriter(){
        try {
            destinationWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        synchronized (destinationWriter) {
            System.out.println("Thread Name : " + Thread.currentThread().getName());
            int c;

            try {
                while ((c = sourceReader.read()) != -1) {
                    destinationWriter.write(c);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    sourceReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}