package exception;
import javax.naming.NameNotFoundException;
import java.util.Scanner;
public class ManuallyThrow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        try {
            if (!name.equals("Vishnu") && !name.equals("balaji") && !name.equals("saurav")) {
                throw new NameNotFoundException("Invalid name");
            }
            System.out.println("welcome to the party...");
        }
            catch(NameNotFoundException e){
                System.out.println("YOu are not allowed " + e.getMessage());
            }
        }
    }

