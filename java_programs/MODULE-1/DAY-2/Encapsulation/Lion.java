package Encapsulation;

class LionMain extends Animal {

        public void sound(){
            System.out.println( name +  " roars");
        }
    }
    public class Lion{
        public static void main(String[] args) {
            Animal lion = new LionMain();
            lion.setName("Lion");
            lion.sound();
        }
    }

