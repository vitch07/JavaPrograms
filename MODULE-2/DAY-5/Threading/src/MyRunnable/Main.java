package MyRunnable;

public class Main {
    public static void main(String[] args){
        Thread t1 = new Thread(new MyRun());
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 20; i++){
            System.out.println( i + "hi another thread");}});

        Thread t3 = new Thread(() -> System.out.println("Third thread"));
        t1.start();
        t2.start();
        t3.start();

        for(int i = 0 ; i < 3; i++) {
            new Thread(() -> {for (int j = 0 ; j < 100; j ++) {
                System.out.println(j + " " + Thread.currentThread().getName());
            }
            }).start();
        }
        System.out.println("Main thread exiting");
    }
}
