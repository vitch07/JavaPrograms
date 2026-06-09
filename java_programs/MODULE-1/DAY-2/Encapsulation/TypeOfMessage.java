package Encapsulation;
import java.util.Scanner;
public class TypeOfMessage {
    public static void main(String[] args){
        Message msg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for the different types of message typing");
        int num = sc.nextInt();
        sc.nextLine(); //to consume the previous enter key
        switch (num){
            case 1:
                msg = new Whatsapp();
                break;
            case 2:
                msg = new Email();
                break;
            default:
                System.out.println("Entered wrong number");
                return;
        }
        System.out.println("Enter the message you want to send");
        String chat = sc.nextLine();
        msg.setMessage(chat);
        msg.sendMessage();

    }
}
