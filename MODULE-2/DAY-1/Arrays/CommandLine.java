package Demo1;

import java.util.Comparator;
import java.util.Scanner;

public class CommandLine {
    public static void main(String[] args){
        String[] names = new String[2];
        names[0] = "vishnu";
        names[1] = "balaji";

        for(int i = 0; i < args.length; i++){
            boolean found = false;
            for (int j = 0; j < names.length;j++){
                if (args[i].equalsIgnoreCase(names[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Illegal entry");
            }
        }
    }
}
