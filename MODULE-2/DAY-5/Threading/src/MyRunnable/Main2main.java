package MyRunnable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main2main {
    public static void main(String[] args) {
        try {
            Thread t1=new Main2("Sachin",new FileInputStream("Sachin.txt"));
            Thread t2=new Main2("Saurav",new FileInputStream("Saurav.txt"));
            Main2.openDestinationWriter();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            Main2.closeDestinationWriter();
            System.out.println("Exiting main thread!!!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
