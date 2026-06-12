package functionalInterface;

public class Main1 {
    public static void main(String[] args){
        class GoodMorn implements Greeting{
            public void greet() {
                System.out.println("Good Morning....");
            }
        }
        class GoodNight implements Greeting {
            public void greet() {
                System.out.println("Good Night......");
            }
        }

            Greeting gm = new GoodMorn();
            gm.greet();


            Greeting gn = new GoodNight();
            gn.greet();
            Greeting goodeve = new Greeting(){
                public void greet(){
                    System.out.println("Good evening .......");
                }
            };
            goodeve.greet();

            Greeting goodAfter = () -> {
                    System.out.println("Good Afternoon..........");
                }; //lambda expression only works on functional interfaces..
            goodAfter.greet();
        }
    }

