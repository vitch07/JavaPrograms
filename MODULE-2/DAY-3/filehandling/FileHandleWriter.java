package filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileHandleWriter {
    public static void main(String[] args){

        try(Writer wr = new FileWriter("src/myFirstFile",true)){
                wr.write("append mode on");
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
