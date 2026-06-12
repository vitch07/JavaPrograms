package filehandling;

import java.io.*;
import java.util.*;

public class CopyFile {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        File inputFile = new File(filename);

        if(!inputFile.exists()){
            System.out.println("File Not Found");
            return;
        }

        try(
                Writer wc = new FileWriter("src/Batman.txt",true);
                BufferedWriter writer = new BufferedWriter(wc);
                BufferedReader reader = new BufferedReader(new FileReader(inputFile)
                ))
            {
                String line;
            while((line = reader.readLine()) != null){
                    writer.write(line);
                    writer.newLine();
            }
        }
        catch(IOException e)   {
            throw new RuntimeException(e);
        }
    }
}
