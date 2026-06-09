package Encapsulation;
import java.util.Scanner;
public class AnimalType {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Animal newObj;
        int num = sc.nextByte();
        switch(num){
            case 1:
                newObj = new Animal();
                newObj.setName("any");
                break;
            case 2,12:
                newObj = new LionMain();
                newObj.setName("Lion");
                break;
            case 3:
                newObj = new Deer();
                newObj.setName("Deer");
                break;
            default:
                newObj = new Animal();
                newObj.setName("any");
                break;
        }

        newObj.sound();
    }

}
