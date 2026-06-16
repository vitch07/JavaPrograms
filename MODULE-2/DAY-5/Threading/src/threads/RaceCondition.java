package threads;

public class RaceCondition {
    public static void main(String[] args){
        Object chop1 = new Object();
        Object chop2 = new Object();

        Thread philosopher1 = new Thread(() -> {
            System.out.println("Philsopher 1 is occupying chop1 ");

            synchronized (chop1){
                System.out.println("philosopher 1 have the chop 1 going for the chop 2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (chop2){
                    System.out.println("Philsopher 1 is holding chop 2 also so he is eating ...");
                }

            }
        });


        Thread philosopher2 = new Thread(() -> {
            System.out.println("Philsopher 2 is occupying chop1 ");

            synchronized (chop2){
                System.out.println("philosopher 2 have the chop 2 going for the chop 1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (chop1){
                    System.out.println("Philsopher 2 is holding chop 1 also so he is eating ...");
                }

            }
        });
        philosopher2.start();
        philosopher1.start();


    }

}
